import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public void save(User user) {
        if (user.getEmail().startsWith("error")) {
            throw new RuntimeException("Unable to save user with email " + user.getEmail());
        }
    }
}
