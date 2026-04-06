import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main2.class);

        CalculatorService calculator = context.getBean(CalculatorService.class);

        // テスト 2-1: addメソッド
        System.out.println("=== テスト 2-1: add(5, 3) ===");
        calculator.add(5, 3);

        // テスト 2-2: subtractメソッド
        System.out.println("\n=== テスト 2-2: subtract(10, 5) ===");
        calculator.subtract(10, 5);

        // テスト 2-3: multiplyメソッド
        System.out.println("\n=== テスト 2-3: multiply(6, 4) ===");
        calculator.multiply(6, 4);

        // テスト 2-4: divideメソッド（正常）
        System.out.println("\n=== テスト 2-4: divide(12, 4) ===");
        calculator.divide(12, 4);

        // テスト 2-5: 複数メソッドの連続実行
        System.out.println("\n=== テスト 2-5: 連続実行 ===");
        calculator.add(1, 2);
        calculator.subtract(5, 2);
        calculator.multiply(3, 4);
        calculator.divide(8, 2);

        context.close();
    }
}
