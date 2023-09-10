package az.developia.librarysystemyusif.service.impl;

import az.developia.librarysystemyusif.entity.Author;
import az.developia.librarysystemyusif.repository.AuthorRepository;
import az.developia.librarysystemyusif.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public String addAuthor(String name) {

        if (!findAuthor(name).isEmpty()){
            return "Belə bir müəllif bazada mövcuddur";
        } else if (name.isEmpty()) {
            return "Müəllif adını yazın";
        }

        Author newAuthor=new Author(name);
        authorRepository.save(newAuthor);

        return "Müəllif "+name+ " bazaya əlavə edildi";
    }

    @Override
    public List<Author> findAuthorList(String name) {

        List<Author> author=authorRepository.findByNameContaining(name);

        return author;
    }

    @Override
    public Optional<Author> findAuthor(String name){
        return authorRepository.findByName(name);
    }


}
