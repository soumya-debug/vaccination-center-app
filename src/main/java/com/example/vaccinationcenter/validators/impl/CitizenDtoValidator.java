package com.example.vaccinationcenter.validators.impl;

import com.example.vaccinationcenter.dtos.CitizenDto;
import com.example.vaccinationcenter.dtos.VaccinationCenterDto;
import com.example.vaccinationcenter.entities.Citizen;
import com.example.vaccinationcenter.entities.VaccinationCenter;
import com.example.vaccinationcenter.validators.antn.CitizenValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class CitizenDtoValidator implements ConstraintValidator<CitizenValidator, CitizenDto> {

	@Override
	public boolean isValid(CitizenDto dto, ConstraintValidatorContext context) {
		return getRequestDtoValidator(dto).validate(dto, context);
	}

	@Override
	public void initialize(CitizenValidator constraintAnnotation) {
	}

	private static RequestDtoValidator<CitizenDto> getRequestDtoValidator(CitizenDto dto) {
		if (dto == null)
			return null;
		if (dto.getHttpMethod().equalsIgnoreCase("post"))
			return new PostRequestValidator();
		if (dto.getHttpMethod().equalsIgnoreCase("put"))
			return new PutRequestValidator();

		return null;
	}

	private static class PostRequestValidator implements RequestDtoValidator<CitizenDto> {

		public boolean validate(CitizenDto citizen, ConstraintValidatorContext context) {
			boolean flag = true;
			if (citizen == null) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Citizen details required").addPropertyNode("citizen")
						.addConstraintViolation();
				return flag;
			}

			if (StringUtils.isBlank(citizen.getName())) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Citizen name required").addPropertyNode("name")
						.addConstraintViolation();
			}

			if (!(citizen.getName().length() > 2 && citizen.getName().length() < 30)) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Citizen name should between 2 and 30 in length")
						.addPropertyNode("name").addConstraintViolation();
			}

			if (StringUtils.isBlank(citizen.getCity())) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Citizen city required").addPropertyNode("city")
						.addConstraintViolation();
			}

			if (!(citizen.getCity().length() > 2 && citizen.getCity().length() < 30)) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Citizen city should between 2 and 30 in length")
						.addPropertyNode("city").addConstraintViolation();
			}

			return flag;
		}
	}

	private static class PutRequestValidator extends PostRequestValidator {

		@Override
		public boolean validate(CitizenDto citizen, ConstraintValidatorContext context) {
			boolean flag = super.validate(citizen, context);

			if (citizen.getDoesCount() > 2 || citizen.getDoesCount() < 0) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Citizen vaccine count should between 0 or 1 or 2")
						.addPropertyNode("doesCount").addConstraintViolation();

			}

			if (citizen.getCenterId() < 1) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("vaccine centerId should be greater than 0")
						.addPropertyNode("centerId").addConstraintViolation();

			}

			if (citizen.getId() < 1) {
				flag = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("citizen Id should be greater than 0")
						.addPropertyNode("id").addConstraintViolation();
			}
			return flag;
		}
	}
}