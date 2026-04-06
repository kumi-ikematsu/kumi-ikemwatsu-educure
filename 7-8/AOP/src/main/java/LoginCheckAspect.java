import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginCheckAspect {

    @Autowired
    private UserSession userSession;

    @Before("execution(* UserService.getUserDetails(..))")
    public void checkLogin() {
        if (!userSession.isLoggedIn()) {
            System.out.println("Exception: User must be logged in to access this method.");
            throw new IllegalStateException("Exception: User must be logged in to access this method.");
        }
    }
}
