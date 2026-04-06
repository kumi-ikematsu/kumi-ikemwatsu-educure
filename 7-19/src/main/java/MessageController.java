import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String messageForm() {
        return "message-form";
    }

    @GetMapping("/message/result")
    public String messageResult(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "message", defaultValue = "") String message,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("message", message);
        return "message-result";
    }
}
