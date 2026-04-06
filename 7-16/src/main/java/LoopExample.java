import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class LoopExample {

    @GetMapping("/loop")
    public String loop(Model model) {
        List<String> items = Arrays.asList("Item1", "Item2", "Item3");
        model.addAttribute("items", items);
        return "loop";
    }
}
