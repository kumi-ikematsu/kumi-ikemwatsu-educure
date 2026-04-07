package com.example;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    // XX-XXXX-XXXX（2〜3桁-4桁-4桁）または XXX-XXXX-XXXX（3桁-4桁-4桁）
    private static final String PHONE_PATTERN = "^\\d{2,3}-\\d{4}-\\d{4}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches(PHONE_PATTERN);
    }
}
