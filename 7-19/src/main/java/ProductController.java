import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "ノートパソコン", 120000));
        products.add(new Product(2, "スマートフォン", 80000));
        products.add(new Product(3, "イヤホン", 12000));
        return products;
    }

    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("products", getProducts());
        return "product-list";
    }

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        for (Product product : getProducts()) {
            if (product.getId() == id) {
                model.addAttribute("product", product);
                return "product-detail";
            }
        }
        return "product-list";
    }
}
