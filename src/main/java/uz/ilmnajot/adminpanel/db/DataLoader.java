package uz.ilmnajot.adminpanel.db;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.ilmnajot.adminpanel.entity.User;
import uz.ilmnajot.adminpanel.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    private String mode;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;




    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")){
        userRepository.save(User.builder()
                        .id(1L)
                        .username("admin@gmail.com")
                        .password(passwordEncoder.encode("admin"))
                        .build());
        }
    }
}
