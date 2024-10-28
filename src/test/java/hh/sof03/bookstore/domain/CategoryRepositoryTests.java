package hh.sof03.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository repo;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repo.findByName("Fiction");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fiction");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Test");
        repo.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category = repo.findByName("Fiction").get(0);
        repo.delete(category);
        assertThat(repo.findByName("Fiction")).isEmpty();
    }
}