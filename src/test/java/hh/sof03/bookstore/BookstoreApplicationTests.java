package hh.sof03.bookstore;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.bookstore.web.BookController;
import hh.sof03.bookstore.web.BookRestController;
import hh.sof03.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookCon;

	@Autowired
	private BookRestController bookRestCon;

	@Autowired
	private CategoryController categoryCon;

	@Test
	void contextLoads() {
		assertThat(bookCon).isNotNull();
		assertThat(bookRestCon).isNotNull();
		assertThat(categoryCon).isNotNull();
	}

	

}
