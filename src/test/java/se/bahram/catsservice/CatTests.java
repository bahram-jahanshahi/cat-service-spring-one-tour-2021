package se.bahram.catsservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class CatTests {

    @Test
    void validCatDoesNotThrowException() {

    }

    @Test
    void catWithLowercaseNameShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cat("tom"));
    }

    @Test
    void getAgeInMonths() {
        Cat cat = new Cat("Paprika", LocalDate.now().minusMonths(9));
        assertThat(cat.getAgeInMonths()).isEqualTo(9);
    }
}
