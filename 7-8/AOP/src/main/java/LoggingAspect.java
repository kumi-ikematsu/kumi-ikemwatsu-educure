import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspect {

    @After("execution(* PaymentService.*(..))")
    public void logAfter() {
        System.out.println("[ログ出力] processPayment メソッドの実行が完了しました。");
    }
}
