package com.example.vaccinationcenter.validators.antn;

import com.example.vaccinationcenter.validators.impl.VaccinationCenterDtoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {VaccinationCenterDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VaccinationCenterValidator {
    String message() default "Invalid Vaccination center data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
