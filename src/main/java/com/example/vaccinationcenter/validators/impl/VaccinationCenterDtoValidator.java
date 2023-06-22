package com.example.vaccinationcenter.validators.impl;

import com.example.vaccinationcenter.dtos.VaccinationCenterDto;
import com.example.vaccinationcenter.validators.antn.VaccinationCenterValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.function.Predicate;

public class VaccinationCenterDtoValidator
    implements ConstraintValidator<VaccinationCenterValidator, VaccinationCenterDto> {

  @Override
  public void initialize(VaccinationCenterValidator constraintAnnotation) {
    // Initialization logic, if needed
  }

  @Override
  public boolean isValid(VaccinationCenterDto dto, ConstraintValidatorContext context) {

    RequestDtoValidator<VaccinationCenterDto> validator = getRequestDtoValidator(dto);
    if (validator == null)
      return true;

    return validator.validate(dto, context);

  }


  public static RequestDtoValidator<VaccinationCenterDto> getRequestDtoValidator(VaccinationCenterDto dto) {
    if (dto == null)
      return null;
    if (dto.getHttpMethod().equalsIgnoreCase("post"))
      return new PostRequestValidator();
    if (dto.getHttpMethod().equalsIgnoreCase("put"))
      return new PutRequestValidator();

    return null;
  }

  private static class PostRequestValidator implements RequestDtoValidator<VaccinationCenterDto> {

    public boolean validate(VaccinationCenterDto center, ConstraintValidatorContext context) {

      boolean flag = true;
      if (center == null) {
        flag = false;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Center Name Should Not Be Null").addPropertyNode("center")
            .addConstraintViolation();
        return flag;
      }

      if (!StringUtils.hasText(center.getName())) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Center Name Required").addPropertyNode("name")
            .addConstraintViolation();
        flag = false;
      }

      Predicate<VaccinationCenterDto> validateNameLength = (VaccinationCenterDto center1) -> {
        return center1.getName().length() > 4 && center1.getName().length() < 60;
      };

      if (validateNameLength.negate().test(center)) {
        context.disableDefaultConstraintViolation();
        context.
            buildConstraintViolationWithTemplate("Center Name Should be between 4 and 60 characters").addPropertyNode("name")
            .addConstraintViolation();
        flag = false;
      }

      if (!StringUtils.hasText(center.getCity())) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Center City Required").addPropertyNode("city")
            .addConstraintViolation();
        flag = false;
      }

      Predicate<VaccinationCenterDto> validateAddressLength = (VaccinationCenterDto center1) -> {
        return center1.getCity().length() > 3 && center1.getCity().length() < 100;
      };

      if (validateAddressLength.negate().test(center)) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Center City Should be between 15 and 100 characters").addPropertyNode("city")
            .addConstraintViolation();
        flag = false;
      }

      return flag;
    }
  }

  private static class PutRequestValidator extends PostRequestValidator {

    @Override
    public boolean validate(VaccinationCenterDto dto, ConstraintValidatorContext context) {
      boolean flag = super.validate(dto, context);

      if (dto.getId() < 1) {
        flag = false;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("center Id should be greater than 0")
            .addPropertyNode("id")
            .addConstraintViolation();
      }
      return flag;
    }
  }
}
