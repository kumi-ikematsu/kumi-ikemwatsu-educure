package com.example;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EventPeriodValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEventPeriod {
    String message() default "期間が正しくありません";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
