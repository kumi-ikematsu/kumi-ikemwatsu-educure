package com.example;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductStockController {

    @GetMapping("/input")
    public String showInputForm(Model model) {
        model.addAttribute("productStockForm", new ProductStockForm());
        return "input";
    }

    @PostMapping("/confirm")
    public String confirm(
            @Valid ProductStockForm productStockForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "input";
        }

        model.addAttribute("stock", productStockForm.getStock());
        return "confirm";
    }
}
