package az.developia.librarysystemyusif.repository;

import az.developia.librarysystemyusif.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByTitle(String title);
    List<Book> findAllByAuthorId(Long id);
    List<Book> findAllByLibrarianId(Long id);
    List<Book> findAllByUserId(Long id);
    List<Book> findByTitleContaining(String name);
}
