import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AuthenticationAspect {

    @Before("execution(* PaymentService.*(..))")
    public void checkAuthentication() {
        System.out.println("[認証チェック] processPayment を実行する前に認証を確認中...");
    }
}
