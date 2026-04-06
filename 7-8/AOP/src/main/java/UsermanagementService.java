import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsermanagementService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        try {
            userRepository.save(user);
            System.out.println("User saved: " + user.getName() + ", " + user.getEmail());
        } catch (RuntimeException e) {
            System.out.println("Exception while saving user: Error: " + e.getMessage());
        }
    }
}
