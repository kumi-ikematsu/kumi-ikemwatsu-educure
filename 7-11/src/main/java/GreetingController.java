import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm() {
        return "greetingForm";
    }

    @PostMapping("/greeting")
    public String greetingResult(
            @RequestParam(name = "name", defaultValue = "") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greetingResult";
    }
}
