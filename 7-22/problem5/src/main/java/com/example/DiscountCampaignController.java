package com.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiscountCampaignController {

    @Autowired
    private DiscountCampaignValidator discountCampaignValidator;

    @GetMapping("/input")
    public String showInputForm(Model model) {
        model.addAttribute("discountCampaignForm", new DiscountCampaignForm());
        return "input";
    }

    @PostMapping("/confirm")
    public String confirm(
            @Valid DiscountCampaignForm discountCampaignForm,
            BindingResult bindingResult,
            Model model) {

        discountCampaignValidator.validate(discountCampaignForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "input";
        }

        model.addAttribute("form", discountCampaignForm);
        return "confirm";
    }
}
