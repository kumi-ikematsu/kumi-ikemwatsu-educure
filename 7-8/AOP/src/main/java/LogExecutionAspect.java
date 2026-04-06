import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionAspect {

    @Around("@annotation(LogExecution)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[LOG] 開始: " + joinPoint.getSignature());

        Object result = joinPoint.proceed();

        System.out.println("[LOG] 終了: " + joinPoint.getSignature());

        return result;
    }
}
