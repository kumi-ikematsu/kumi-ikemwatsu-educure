import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdvancedThymeleafExample {

    @GetMapping("/advanced")
    public String advanced(Model model) {

        // userをMapオブジェクトにまとめて渡す
        Map<String, String> user = new HashMap<>();
        user.put("name", "Bob");
        user.put("role", "Admin");
        user.put("status", "ACTIVE");
        model.addAttribute("user", user);

        // productsリストにProductオブジェクトを追加して渡す
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0));
        products.add(new Product("Smartphone", 800.0));
        products.add(new Product("Tablet", 450.0));
        model.addAttribute("products", products);

        return "advanced";
    }
}
