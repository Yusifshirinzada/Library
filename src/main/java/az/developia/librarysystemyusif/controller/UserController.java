package az.developia.librarysystemyusif.controller;

import az.developia.librarysystemyusif.service.LibrarianService;
import az.developia.librarysystemyusif.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final LibrarianService librarianService;

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("login seyfesine xos geldiniz");
    }

    @GetMapping("/home")
    public String dashboard(){
        return "Xoş gəldiniz "+librarianService.checkUser().getUsername();
    }


}
