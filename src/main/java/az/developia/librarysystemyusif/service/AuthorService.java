package az.developia.librarysystemyusif.service;

import az.developia.librarysystemyusif.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    String addAuthor(String name);
    Optional<Author> findAuthor(String name);

    List<Author> findAuthorList(String name);
}
