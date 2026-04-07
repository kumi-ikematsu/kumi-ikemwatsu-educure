package com.example;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "正しい電話番号形式で入力してください";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
