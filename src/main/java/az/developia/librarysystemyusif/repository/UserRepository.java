package az.developia.librarysystemyusif.repository;

import az.developia.librarysystemyusif.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
    List<User> findByLibrarianId(Long librarianId);
}
