package com.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.LocalDate;

@Component
public class DiscountCampaignValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return DiscountCampaignForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DiscountCampaignForm form = (DiscountCampaignForm) target;

        String type = form.getType();
        Integer value = form.getValue();
        LocalDate startDate = form.getStartDate();
        LocalDate endDate = form.getEndDate();

        // 割引値チェック（種別ごと）
        if (value != null && type != null) {
            if ("fixed".equals(type)) {
                // 100円単位チェック
                if (value % 100 != 0) {
                    errors.rejectValue("value", "", "定額割引は100円単位で入力してください");
                }
                // 上限チェック
                if (value > 10000) {
                    errors.rejectValue("value", "", "定額割引は最大10,000円までです");
                }
            } else if ("percent".equals(type)) {
                // 1〜50%チェック
                if (value < 1 || value > 50) {
                    errors.rejectValue("value", "", "定率割引は1〜50%の範囲で入力してください");
                }
            }
        }

        // 開始日チェック
        if (startDate != null) {
            if (startDate.isBefore(LocalDate.now())) {
                errors.rejectValue("startDate", "", "開始日は本日以降を指定してください");
            }
        }

        // 終了日チェック
        if (startDate != null && endDate != null) {
            // 終了日が開始日より後
            if (!endDate.isAfter(startDate)) {
                errors.rejectValue("endDate", "", "終了日は開始日より後の日付にしてください");
            }
            // 最大1ヶ月チェック
            if (endDate.isAfter(startDate.plusMonths(1))) {
                errors.rejectValue("endDate", "", "キャンペーン期間は最大1ヶ月までです");
            }
        }
    }
}
