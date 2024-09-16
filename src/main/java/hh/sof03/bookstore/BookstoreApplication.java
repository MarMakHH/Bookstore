package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(
					new Book("Hobitti : eli Sinne ja takaisin", "J. R. R. Tolkien", 2024, "9789510468524", 27.90));
			repository.save(new Book("JAVA-OHJELMOINTI + CD", "Kyppö Jorma", 2008, "9789521413568", 51.00));
			repository.save(new Book("Spring Boot 3 and Spring Framework 6", "Christian Ullenboom", 2024,
					"9781493224753", 55.90));

			System.out.println("Books found with findAll():");
			System.out.println("-------------------------------");
			repository.findAll().forEach(book -> {
				System.out.println(book.toString());
			});
		};
	}
}
