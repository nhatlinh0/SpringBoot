package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryImplTests {
    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void testFindUser() {
        List<User> user = userRepository.getUserForSA();
        Assertions.assertEquals(1, user.size());
    }
}
