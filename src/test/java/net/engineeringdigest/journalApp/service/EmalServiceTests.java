package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmalServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendMail() {
        String to = "linhdalat144@gmail.com";
        String subject = "Testing Java mail sender";
        String body = "Hi";
        emailService.sendEmail(to, subject, body);
    }
}
