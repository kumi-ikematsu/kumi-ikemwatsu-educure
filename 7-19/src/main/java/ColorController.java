import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ColorController {

    @GetMapping("/color")
    public String colorForm() {
        return "color-select";
    }

    @GetMapping("/color/result")
    public String colorResult(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "color", defaultValue = "") String color,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("color", color);
        return "color-result";
    }
}
