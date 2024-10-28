package hh.sof03.bookstore.domain;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookrepo;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookrepo.findByTitle("Hobitti : eli Sinne ja takaisin");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Hobitti : eli Sinne ja takaisin");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Book title", "writer", 2020, "-", 10.0, null);
        bookrepo.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Book book = bookrepo.findByTitle("Hobitti : eli Sinne ja takaisin").get(0);
        bookrepo.delete(book);
        assertThat(bookrepo.findByTitle("Hobitti : eli Sinne ja takaisin")).isEmpty();
    }
}
