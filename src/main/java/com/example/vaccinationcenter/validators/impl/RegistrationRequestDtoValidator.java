package com.example.vaccinationcenter.validators.impl;

import com.example.vaccinationcenter.dtos.LoginRequestDto;
import com.example.vaccinationcenter.dtos.RegistrationRequestDto;
import com.example.vaccinationcenter.validators.antn.LoginRequestValidator;
import com.example.vaccinationcenter.validators.antn.RegistrationRequestValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class RegistrationRequestDtoValidator implements ConstraintValidator<RegistrationRequestValidator, RegistrationRequestDto> {

  @Override
  public boolean isValid(RegistrationRequestDto value, ConstraintValidatorContext context) {
    boolean flag = true;

    if (StringUtils.isBlank(value.getName())) {
      flag = false;
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("name required")
          .addPropertyNode("name")
          .addConstraintViolation();

    }

    if (!(value.getName().length() > 4 && value.getName().length() < 30)) {
      flag = false;
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("name length should be between 4 and 30 ")
          .addPropertyNode("name")
          .addConstraintViolation();
    }

    LoginRequestDto loginRequestDto = new LoginRequestDto();
    loginRequestDto.setEmail(value.getEmail());
    loginRequestDto.setPassword(value.getPassword());
    ConstraintValidator<LoginRequestValidator, LoginRequestDto> validator = new LoginRequestDtoValidator();
    flag = validator.isValid(loginRequestDto, context);


    return flag;
  }

  @Override
  public void initialize(RegistrationRequestValidator constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }
}
