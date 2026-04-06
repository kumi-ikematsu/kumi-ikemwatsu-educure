import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdvancedThymeleafExample {

    @GetMapping("/advanced")
    public String advanced(Model model) {

        model.addAttribute("name", "Bob");
        model.addAttribute("role", "Admin");
        model.addAttribute("status", "ACTIVE");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0));
        products.add(new Product("Smartphone", 800.0));
        products.add(new Product("Tablet", 450.0));
        model.addAttribute("products", products);

        return "advanced";
    }
}
