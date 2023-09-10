package az.developia.librarysystemyusif.service;

import az.developia.librarysystemyusif.entity.User;

public interface LibrarianService {

//    String userRegistration(UserDetailsRequest userDetailsRequest);
//
//    String updateUserDetails(Long id, UserDetailsRequest request);
//
//    List<User> showUsersByLibrarianId();
//
//    Optional<User> findUser(String username);
//
//    String deleteUser(Long id);

    String encoderPassword(String password);

    User checkUser();
}
