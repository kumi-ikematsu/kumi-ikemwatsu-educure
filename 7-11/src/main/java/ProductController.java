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
        products.add(new Product(1, "商品1", 1000.0, "商品1の詳細説明"));
        products.add(new Product(2, "商品2", 2000.0, "商品2の詳細説明"));
        products.add(new Product(3, "商品3", 3000.0, "商品3の詳細説明"));
        return products;
    }

    @GetMapping("/product")
    public String productList(Model model) {
        model.addAttribute("products", getProducts());
        return "productList";
    }

    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        for (Product product : getProducts()) {
            if (product.getId() == id) {
                model.addAttribute("product", product);
                return "productDetail";
            }
        }
        return "error";
    }
}
