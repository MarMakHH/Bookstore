package hh.sof03.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AppUserRepositoryTests {
    @Autowired
    private AppUserRepository repo;

    @Test
    public void findByUsernameShouldReturnAppUser() {
        AppUser user = repo.findByUsername("user");
        assertThat(user.getUsername()).isEqualTo("user");
    }

    @Test
    public void createNewAppUser() {
        AppUser user = new AppUser("testi", "user", "user", "user");
        repo.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteAppUser() {
        AppUser user = repo.findByUsername("user");
        repo.delete(user);
        assertThat(repo.findByUsername("user")).isNull();;
    }
}