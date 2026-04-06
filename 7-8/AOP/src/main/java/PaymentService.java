import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void processPayment() {
        System.out.println("支払い処理を実行中...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("支払い完了");
    }
}
