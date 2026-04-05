package jp.educure.problem1.messagesender;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
