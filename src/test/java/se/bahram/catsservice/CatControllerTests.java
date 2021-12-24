package se.bahram.catsservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
public class CatControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CatRepository catRepository;

    @Test
    void getCatWithNameShouldReturnCat() throws Exception{
        Cat toby = new Cat("Toby");
        BDDMockito.given(catRepository.findByName("Toby")).willReturn(toby);
        String expectedValue = this.objectMapper.writeValueAsString(toby);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/cats/{name}", "Toby"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(expectedValue));
    }
}
