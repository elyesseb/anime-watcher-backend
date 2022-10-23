package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ufhopla
 * on 21/10/2022.
 */

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserRepository userRepository;

    // testing depedencies working fine
    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(userRepository).isNotNull();
    }

    // testing repository working fine
    @Test
    public void shouldFindNoUserIfRepositoryIsEmpty() {
        Iterable<User> users = userRepository.findAll();
        assertThat(users).isEmpty();
    }

    // testing methode working fine
    @Test
    void existsByUsername() {
        // given
        User toto = new User("toto", "toto@gmail.com", "123456");
        entityManager.persist(toto);
        entityManager.flush();
        // when
        boolean found = userRepository.existsByUsername("toto");
        // then
        assertThat(found).isTrue();
    }

    // testing methode working fine
    @Test
    void existsByEmail() {
        // given
        User toto = new User("toto", "toto@gmail.com", "123456");
        entityManager.persist(toto);
        entityManager.flush();
        // when
        boolean found = userRepository.existsByEmail("toto@gmail.com");
        // then
        assertThat(found).isTrue();
    }
}
