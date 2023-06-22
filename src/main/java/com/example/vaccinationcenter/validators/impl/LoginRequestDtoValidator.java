package com.example.vaccinationcenter.validators.impl;

import com.example.vaccinationcenter.dtos.CitizenDto;
import com.example.vaccinationcenter.dtos.LoginRequestDto;
import com.example.vaccinationcenter.validators.antn.CitizenValidator;
import com.example.vaccinationcenter.validators.antn.LoginRequestValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class LoginRequestDtoValidator implements ConstraintValidator<LoginRequestValidator, LoginRequestDto> {

  @Override
  public boolean isValid(LoginRequestDto value, ConstraintValidatorContext context) {
    boolean flag = true;
    if(StringUtils.isBlank(value.getEmail()))
    {
      flag = false;
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("email required")
          .addPropertyNode("email").addConstraintViolation();
    }

    if(!(value.getEmail().length() > 4 && value.getEmail().length() < 30))
    {
      flag = false;
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("email length should be between 4 and 30")
          .addPropertyNode("email").addConstraintViolation();
    }

    if(StringUtils.isBlank(value.getPassword()))
    {
      flag = false;
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("password required")
          .addPropertyNode("password").addConstraintViolation();
    }


    if(!(value.getPassword().length() > 6 && value.getPassword().length() < 10))
    {
      flag = false;
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("password length should be between 6 and 10")
          .addPropertyNode("password").addConstraintViolation();
    }

    return flag;
  }

  @Override
  public void initialize(LoginRequestValidator constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }
}
