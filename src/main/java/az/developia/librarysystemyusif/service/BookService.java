package az.developia.librarysystemyusif.service;

import az.developia.librarysystemyusif.entity.Book;
import az.developia.librarysystemyusif.request.BookRequest;

import java.util.List;

public interface BookService {
    String addBook(BookRequest bookRequest);
    Book findBook(String bookTitle);
    List<Book> findBookByAuthor(String authorName);
    List<Book> showAllBooks();

    List<Book> showAllLibrariansBook();

    String deleteBookById(Long id);
    String updateBookById(Long id,BookRequest request);

    List<Book> findBookByName(String name);
}
