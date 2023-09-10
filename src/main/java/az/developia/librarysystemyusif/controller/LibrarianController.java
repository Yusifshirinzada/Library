package az.developia.librarysystemyusif.controller;

import az.developia.librarysystemyusif.entity.Book;
import az.developia.librarysystemyusif.entity.User;
import az.developia.librarysystemyusif.request.AuthorRequest;
import az.developia.librarysystemyusif.request.BookRequest;
import az.developia.librarysystemyusif.request.UserDetailsRequest;
import az.developia.librarysystemyusif.service.BookService;
import az.developia.librarysystemyusif.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarian")
@RequiredArgsConstructor
public class LibrarianController {


    private final BookService bookService;
    private final UserService userService;

    @GetMapping("/admin")
    public String admin(){
        return "Admin page";
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> userRegistration(@RequestBody UserDetailsRequest request){
        return ResponseEntity.ok(userService.userRegistration(request));
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.addBook(bookRequest));
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable Long id,@RequestBody BookRequest request  ){
        return ResponseEntity.ok(bookService.updateBookById(id,request));
    }

    @PutMapping("/updateUser/{id}")
    private ResponseEntity<String> updateUserById(@PathVariable Long id,@RequestBody UserDetailsRequest request){
        return ResponseEntity.ok(userService.updateUserDetails(id,request));
    }

    @GetMapping("/showAllBooks")
    public List<Book> showAllBooks(){
        return bookService.showAllBooks();
    }

    @GetMapping("/showAllLibrariansBook")
    public List<Book> showAllLibrariansBook(){
        return bookService.showAllLibrariansBook();
    }

    @PostMapping("/findBookByAuthorName")
    public List<Book> findBookByAuthorName(@RequestBody AuthorRequest request){
        return bookService.findBookByAuthor(request.getName());
    }

    @PostMapping("/findBookByName")
    public List<Book> findBookByName(@RequestBody BookRequest request){
        return bookService.findBookByName(request.getTitle());
    }

    @PostMapping("/findUserByName")
    public ResponseEntity<User> findUserByName(@RequestBody UserDetailsRequest request){
        return ResponseEntity.ok(userService.findUser(request.getUsername()).get());
    }

    @GetMapping("/showUsersByLibrarianId")
    public List<User> showUsersByLibrarianId(){
        return userService.showUsersByLibrarianId();
    }

    @DeleteMapping("/deleteBookById")
    public ResponseEntity<String> deleteBookById(@RequestBody BookRequest request){
        return ResponseEntity.ok((bookService.deleteBookById(request.getId())));
    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> deleteUserById(@RequestBody UserDetailsRequest request){
        return ResponseEntity.ok(userService.deleteUser(request.getId()));
    }



}
