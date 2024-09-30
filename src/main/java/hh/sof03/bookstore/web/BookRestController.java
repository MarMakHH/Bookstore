package hh.sof03.bookstore.web;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookRestController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/books")
    public @ResponseBody List<Book> booksListRest() {
        return (List<Book>) repo.findAll();
    }
    
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repo.findById(bookId);
    }
}
