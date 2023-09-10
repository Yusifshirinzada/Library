package az.developia.librarysystemyusif.service;

import az.developia.librarysystemyusif.entity.Book;
import az.developia.librarysystemyusif.entity.User;
import az.developia.librarysystemyusif.request.UserDetailsRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Book> showMyBooks();

    String userRegistration(UserDetailsRequest userDetailsRequest);

    String updateUserDetails(Long id, UserDetailsRequest request);

    List<User> showUsersByLibrarianId();

    Optional<User> findUser(String username);

    String deleteUser(Long id);

}
