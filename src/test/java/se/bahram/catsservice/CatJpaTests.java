package se.bahram.catsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class CatJpaTests {

    @Autowired
    private CatRepository catRepository;

    @Test
    void findByNameReturnsCat() {
        this.catRepository.save(new Cat("Toby"));
        assertThat(this.catRepository.findByName("Toby").getName()).isEqualTo("Toby");
    }
}
