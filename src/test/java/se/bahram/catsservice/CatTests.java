package se.bahram.catsservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CatTests {

    @Test
    void validCatDoesNotThrowException() {

    }

    @Test
    void catWithLowercaseNameShouldThrowException(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Cat("tom"));
    }
}
