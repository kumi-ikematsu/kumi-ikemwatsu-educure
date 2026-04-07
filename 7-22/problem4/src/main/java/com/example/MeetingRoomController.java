package com.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MeetingRoomController {

    @Autowired
    private MeetingRoomValidator meetingRoomValidator;

    @GetMapping("/input")
    public String showInputForm(Model model) {
        model.addAttribute("meetingRoomForm", new MeetingRoomForm());
        return "input";
    }

    @PostMapping("/confirm")
    public String confirm(
            @Valid MeetingRoomForm meetingRoomForm,
            BindingResult bindingResult,
            Model model) {

        // カスタムバリデーション追加実行
        meetingRoomValidator.validate(meetingRoomForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "input";
        }

        model.addAttribute("form", meetingRoomForm);
        return "confirm";
    }
}
