package com.raphael.cardealership.domain.shared;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AfterPlatformLaunchImpl implements ConstraintValidator<AfterPlatformLaunch, LocalDate> {
    @Override
    public boolean isValid(final LocalDate localDate, final ConstraintValidatorContext constraintValidatorContext) {
        return localDate.isAfter(LocalDate.of(2022, 1, 1));
    }

    @Override
    public void initialize(final AfterPlatformLaunch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
