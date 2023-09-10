package az.developia.librarysystemyusif.service.impl;

import az.developia.librarysystemyusif.entity.Author;
import az.developia.librarysystemyusif.entity.Book;
import az.developia.librarysystemyusif.repository.BookRepository;
import az.developia.librarysystemyusif.request.BookRequest;
import az.developia.librarysystemyusif.service.AuthorService;
import az.developia.librarysystemyusif.service.BookService;
import az.developia.librarysystemyusif.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final LibrarianService librarianService;

    @Override
    public String addBook(BookRequest bookRequest) {

        Optional<BookRequest> request=Optional.ofNullable(bookRequest);

        if (request.isEmpty()||request.get().getTitle().isEmpty()||request.get().getAuthor().isEmpty()||request.get().getYear()==0){
            return "Məlumatları tam doldurduğunuzdan əmin olun";
        } else if (!Optional.ofNullable(findBook(bookRequest.getTitle())).isEmpty()) {
            return "Bu kitab bazada mövcuddur";
        }


        if(authorService.findAuthor(request.get().getAuthor()).isEmpty()){
            authorService.addAuthor(request.get().getAuthor());
        }

        Book book=Book.builder()
                .title(bookRequest.getTitle().toUpperCase())
                .year(Year.of(bookRequest.getYear()))
                .author(authorService.findAuthor(bookRequest.getAuthor()).get())
                .librarianId(librarianService.checkUser())
                .build();

        bookRepository.save(book);

        return book.getTitle()+" kitabı bazaya əlavə edildi";
    }

    @Override
    public Book findBook(String bookTitle) {
        return bookRepository.findByTitle(bookTitle.toUpperCase());
    }

    @Override
   public List<Book> findBookByAuthor(String authorName){
        List<Author> author=authorService.findAuthorList(authorName);
        if(author.isEmpty()){
            return null;
        }
        List<Book> bookList=new ArrayList<>();

        for (int i=0;i<author.size();i++){
            List<Book> authorBook=bookRepository.findAllByAuthorId(author.get(i).getId());
            for (int j=0;j<authorBook.size();j++){
                bookList.add(authorBook.get(j));
            }

        }

        return bookList;
    }

    @Override
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> showAllLibrariansBook(){
        Long id=librarianService.checkUser().getId();
        return bookRepository.findAllByLibrarianId(id);
    }

    @Override
    public String deleteBookById(Long id){
        Optional<Book> book=bookRepository.findById(id);
        if(book.isEmpty()){
            return "Belə bir kitab bazada yoxdur";
        }

        bookRepository.delete(book.get());

        return book.get().getTitle()+" kitabı bazadan silindi";
    }

    @Override
    public String updateBookById(Long id,BookRequest request) {
        Optional<Book> checkBook=bookRepository.findById(id);

        if(checkBook.isEmpty()){
            return "Belə bir kitab bazada mövcud deyildir";
        }


        if(!request.getTitle().isEmpty()){
            checkBook.get().setTitle(request.getTitle());
        }
        if (!(request.getYear()==0)){
            checkBook.get().setYear(Year.of(request.getYear()));
        }

        if(!request.getAuthor().isEmpty()){
            Optional<Author> author=authorService.findAuthor(request.getAuthor());
            if(author.isEmpty()){
                authorService.addAuthor(request.getAuthor());
                checkBook.get().setAuthor(authorService.findAuthor(request.getAuthor()).get());
            }else {
                checkBook.get().setAuthor(author.get());
            }
        }

        bookRepository.save(checkBook.get());

        return "Kitab məlumatları uğurla dəyişdirildi";
    }

    @Override
    public List<Book> findBookByName(String name){
        return bookRepository.findByTitleContaining(name);
    }
}
