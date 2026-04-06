import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main3.class);

        UsermanagementService service = context.getBean(UsermanagementService.class);

        // テスト 3-1: 正常なユーザー保存
        System.out.println("=== テスト 3-1: 正常なユーザー保存 ===");
        service.createUser(new User("John Doe", "john.doe@example.com"));

        // テスト 3-2: エラーメールでの保存試行
        System.out.println("\n=== テスト 3-2: エラーメールでの保存試行 ===");
        service.createUser(new User("Error User", "error@example.com"));

        // テスト 3-3: 別の正常ユーザー保存
        System.out.println("\n=== テスト 3-3: 別の正常ユーザー保存 ===");
        service.createUser(new User("Jane Smith", "jane.smith@example.com"));

        // テスト 3-4: 日本語名での正常保存
        System.out.println("\n=== テスト 3-4: 日本語名での正常保存 ===");
        service.createUser(new User("田中太郎", "tanaka@example.com"));

        context.close();
    }
}
