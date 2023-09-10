package az.developia.librarysystemyusif.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoad implements ApplicationRunner {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final LibrarianService librarianService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//
//        Role roleAdmin= Role.builder().name("LIBRARIAN").build();
//        Role roleUser= Role.builder().name("USER").build();
//
//        roleRepository.save(roleAdmin);
//        roleRepository.save(roleUser);
//
//
//        String password=passwordEncoder.encode("1234");
//
//        User admin=User.builder()
//                .username("Librarian")
//                .password(librarianService.encoderPassword("1234"))
//                .name("Admin")
//                .role(roleRepository.findByName("LIBRARIAN"))
//                .build();
//
//        userRepository.save(admin);
//
//
//        User user=User.builder()
//                .username("User")
//                .password(librarianService.encoderPassword("1234"))
//                .name("User")
//                .role(roleRepository.findByName("USER"))
//                .librarianId(admin)
//                .build();
//
//
//        userRepository.save(user);

    }
}
