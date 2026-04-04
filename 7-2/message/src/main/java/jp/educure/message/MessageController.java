package jp.educure.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class MessageController {

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/message")
    public String showMessage(
            @RequestParam(value = "message", defaultValue = "") String message,
            @RequestParam(value = "color", defaultValue = "") String color,
            Map<String, Object> model) {

        if (message.isEmpty()) {
            message = "No message provided";
        }
        if (color.isEmpty()) {
            color = "black";
        }

        model.put("message", message);
        model.put("color", color);
        model.put("postedAt", LocalDateTime.now());

        return "message";
    }
}
