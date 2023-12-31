package az.developia.librarysystemyusif.repository;


import az.developia.librarysystemyusif.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findByNameContaining(String name);
    Optional<Author> findByName(String name);

}
