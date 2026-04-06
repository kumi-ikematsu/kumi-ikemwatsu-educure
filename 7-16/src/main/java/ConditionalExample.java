import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConditionalExample {

    @GetMapping("/conditional")
    public String conditional(Model model) {
        model.addAttribute("isLoggedIn", true);
        return "conditional";
    }
}
