import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main1.class);

        UserSession userSession = context.getBean(UserSession.class);
        UserService userService = context.getBean(UserService.class);

        // テスト 1-1: ログイン前のアクセス
        System.out.println("=== テスト 1-1: ログイン前のアクセス ===");
        try {
            userService.getUserDetails();
        } catch (IllegalStateException e) {
            // アスペクト側でメッセージ出力済み
        }

        // テスト 1-2: ログイン後のアクセス
        System.out.println("\n=== テスト 1-2: ログイン後のアクセス ===");
        userSession.login();
        userService.getUserDetails();

        // テスト 1-3: ログアウト後のアクセス
        System.out.println("\n=== テスト 1-3: ログアウト後のアクセス ===");
        userSession.logout();
        try {
            userService.getUserDetails();
        } catch (IllegalStateException e) {
            // アスペクト側でメッセージ出力済み
        }

        context.close();
    }
}
