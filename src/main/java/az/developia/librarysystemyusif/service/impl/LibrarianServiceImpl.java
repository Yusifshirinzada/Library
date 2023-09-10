package az.developia.librarysystemyusif.service.impl;


import az.developia.librarysystemyusif.entity.User;
import az.developia.librarysystemyusif.repository.UserRepository;
import az.developia.librarysystemyusif.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public String encoderPassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public User checkUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();

        return userRepository.findByUsername(loggedInUsername);
    }

}
