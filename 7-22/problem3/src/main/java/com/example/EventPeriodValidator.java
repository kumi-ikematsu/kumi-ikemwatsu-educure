package com.example;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class EventPeriodValidator implements ConstraintValidator<ValidEventPeriod, EventPeriodForm> {

    @Override
    public boolean isValid(EventPeriodForm form, ConstraintValidatorContext context) {
        LocalDate startDate = form.getStartDate();
        LocalDate endDate = form.getEndDate();

        // null チェックは各フィールドのアノテーションで対応するためここではtrue返す
        if (startDate == null || endDate == null) {
            return true;
        }

        boolean valid = true;

        // 開始日は本日以降
        if (startDate.isBefore(LocalDate.now())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("開始日は本日以降の日付を入力してください")
                    .addPropertyNode("startDate")
                    .addConstraintViolation();
            valid = false;
        }

        // 終了日は開始日より後
        if (!endDate.isAfter(startDate)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("終了日は開始日より後の日付でなければなりません")
                    .addPropertyNode("endDate")
                    .addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
