package az.developia.librarysystemyusif.service.impl;

import az.developia.librarysystemyusif.entity.Book;
import az.developia.librarysystemyusif.entity.Role;
import az.developia.librarysystemyusif.entity.User;
import az.developia.librarysystemyusif.repository.BookRepository;
import az.developia.librarysystemyusif.repository.UserRepository;
import az.developia.librarysystemyusif.request.UserDetailsRequest;
import az.developia.librarysystemyusif.service.LibrarianService;
import az.developia.librarysystemyusif.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LibrarianService librarianService;
    private final BookRepository bookRepository;

    @Override
    public List<Book> showMyBooks(){
        Long id=librarianService.checkUser().getId();
        return bookRepository.findAllByUserId(id);
    }


    @Override
    public String userRegistration(UserDetailsRequest userDetailsRequest) {

        Optional<UserDetailsRequest> request = Optional.ofNullable(userDetailsRequest);

        if(request.get().getName().isEmpty()){
            return "Adı daxil edin";
        } else if (request.get().getUsername().length()<4) {
            return "İstifadəçi adı düzgün daxil edilməyib.İstifadəçi adının uzunluğu 5-dən az olmamalıdır";
        } else if (request.get().getPassword().length()<8) {
            return "Şifrə düzgün yazılmayıb.Şifrənin uzunluğu 8-dən az olmamalıdır";
        } else if (!(findUser(userDetailsRequest.getUsername()).isEmpty())) {
            return "İstifadəçi artıq mövcuddur";
        }


        User user=User.builder()
                .username(userDetailsRequest.getUsername())
                .password(librarianService.encoderPassword(userDetailsRequest.getPassword()))
                .name(userDetailsRequest.getName())
                .role(Role.builder().id(2l).build())
                .librarianId(librarianService.checkUser())
                .build();

        userRepository.save(user);

        return "Qeydiyyat ugurlu oldu." +
                "\nİstifadəçi adınız: "+ userDetailsRequest.getUsername()+
                "\nŞifrəniz: "+ userDetailsRequest.getPassword();
    }

    @Override
    public String updateUserDetails(Long id, UserDetailsRequest request){

        Optional<User> checkUser=userRepository.findById(id);

        if(checkUser.isEmpty()){
            return "İstifadəçi bazada mövcud deyil";
        }

        if(!request.getUsername().isEmpty()){
            checkUser.get().setUsername(request.getUsername());
        }
        if (!(request.getPassword().isEmpty())){
            checkUser.get().setPassword(librarianService.encoderPassword(request.getPassword()));
        }
        if(!request.getName().isEmpty()){
            checkUser.get().setName(request.getName());
        }


        userRepository.save(checkUser.get());

        return "İstifadəçi məlumatları yeniləndi";
    }

    @Override
    public List<User> showUsersByLibrarianId(){
        Long id=librarianService.checkUser().getId();
        return userRepository.findByLibrarianId(id);
    }

    @Override
    public Optional<User> findUser(String username) {

        Optional<User> user=Optional.ofNullable(userRepository.findByUsername(username));

        return user;
    }

    @Override
    public String deleteUser(Long id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            return "Belə bir istifadəçi bazada yoxdur";
        }

        userRepository.delete(user.get());

        return "İstifadəçi "+user.get().getUsername()+" bazadan silindi";
    }


}
