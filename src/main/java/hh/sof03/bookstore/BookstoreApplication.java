package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookrepo, CategoryRepository categoryrepo) {
		return (args) -> {
			Category c1 = new Category("Fiction");
			categoryrepo.save(c1);
			Category c2 = new Category("Textbook");
			categoryrepo.save(c2);
			Category c3 = new Category("Scifi");
			categoryrepo.save(c3);

			bookrepo.save(
					new Book("Hobitti : eli Sinne ja takaisin", "J. R. R. Tolkien", 2024, "9789510468524", 27.90, c1));
			bookrepo.save(new Book("JAVA-OHJELMOINTI + CD", "Kyppö Jorma", 2008, "9789521413568", 51.00, c2));
			bookrepo.save(new Book("Spring Boot 3 and Spring Framework 6", "Christian Ullenboom", 2024,
					"9781493224753", 55.90, c2));

			log.info("Categories found with findAll()");
			categoryrepo.findAll().forEach(category -> {
				log.info(category.toString());
			});

			log.info("Books found with findAll():");
			bookrepo.findAll().forEach(book -> {
				log.info(book.toString());
			});
		};
	}
}
