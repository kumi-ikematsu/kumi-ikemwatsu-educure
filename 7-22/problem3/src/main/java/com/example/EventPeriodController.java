package com.example;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventPeriodController {

    @GetMapping("/input")
    public String showInputForm(Model model) {
        model.addAttribute("eventPeriodForm", new EventPeriodForm());
        return "input";
    }

    @PostMapping("/confirm")
    public String confirm(
            @Valid EventPeriodForm eventPeriodForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "input";
        }

        model.addAttribute("startDate", eventPeriodForm.getStartDate());
        model.addAttribute("endDate", eventPeriodForm.getEndDate());
        return "confirm";
    }
}
