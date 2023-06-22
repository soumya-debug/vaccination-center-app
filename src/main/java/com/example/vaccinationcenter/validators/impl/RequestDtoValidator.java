package com.example.vaccinationcenter.validators.impl;

import jakarta.validation.ConstraintValidatorContext;

public interface RequestDtoValidator<T> {

  public boolean validate(T requestData, ConstraintValidatorContext context);
}
