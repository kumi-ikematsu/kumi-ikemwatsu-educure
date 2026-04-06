import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main5 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main5.class);

        PaymentService paymentService = context.getBean(PaymentService.class);

        // テスト 5-1: 複数アスペクトの順序実行確認
        System.out.println("=== テスト 5-1: 複数アスペクトの順序実行確認 ===");
        paymentService.processPayment();

        // テスト 5-2: アスペクト実行順序の確認（複数回）
        System.out.println("\n=== テスト 5-2: 複数回実行 ===");
        paymentService.processPayment();
        paymentService.processPayment();

        context.close();
    }
}
