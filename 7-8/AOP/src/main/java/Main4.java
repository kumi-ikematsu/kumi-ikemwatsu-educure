import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main4 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main4.class);

        OrderService orderService = context.getBean(OrderService.class);

        // テスト 4-1: @LogExecution付きメソッドの実行
        System.out.println("=== テスト 4-1: @LogExecution付きメソッドの実行 ===");
        orderService.processOrder();

        // テスト 4-2: 複数回連続実行での動作確認
        System.out.println("\n=== テスト 4-2: 複数回連続実行 ===");
        orderService.processOrder();
        orderService.processOrder();
        orderService.processOrder();

        context.close();
    }
}
