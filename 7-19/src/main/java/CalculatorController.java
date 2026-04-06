import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculatorForm() {
        return "calculator";
    }

    @GetMapping("/calculator/result")
    public String calculatorResult(
            @RequestParam(name = "num1") int num1,
            @RequestParam(name = "num2") int num2,
            @RequestParam(name = "operation") String operation,
            Model model) {

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);

        if (operation.equals("/") && num2 == 0) {
            model.addAttribute("error", "Error: Division by zero is not allowed.");
            return "result";
        }

        int result;
        switch (operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
            default:
                model.addAttribute("error", "Error: Invalid operation.");
                return "result";
        }

        model.addAttribute("result", result);
        return "result";
    }
}
