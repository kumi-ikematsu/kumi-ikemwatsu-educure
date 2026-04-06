import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @LogExecution
    public void processOrder() {
        System.out.println("注文処理中...");
        System.out.println("注文処理完了");
    }
}
