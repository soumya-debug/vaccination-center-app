package com.example.vaccinationcenter.validators.antn;

import com.example.vaccinationcenter.validators.impl.LoginRequestDtoValidator;
import com.example.vaccinationcenter.validators.impl.RegistrationRequestDtoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {RegistrationRequestDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistrationRequestValidator {
  String message() default "Invalid Registration quest data";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
