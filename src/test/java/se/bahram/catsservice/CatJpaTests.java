package se.bahram.catsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class CatJpaTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CatRepository catRepository;

    @Test
    void catCanBePersisted() {
        assertThatNoException().isThrownBy(() -> this.testEntityManager.persist(new Cat("Toby")));
    }

    @Test
    void findByNameReturnsCat() {
        this.catRepository.save(new Cat("Toby"));
        assertThat(this.catRepository.findByName("Toby").getName()).isEqualTo("Toby");
    }
}
