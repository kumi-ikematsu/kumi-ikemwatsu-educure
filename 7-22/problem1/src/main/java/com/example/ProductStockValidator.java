package com.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductStockValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductStockForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // アノテーションバリデーションで対応済み
        // 追加のカスタムバリデーションが必要な場合はここに記述
    }
}
