package se.bahram.catsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatRestController {

    final CatRepository catRepository;

    public CatRestController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @GetMapping("/cats/{name}")
    Cat byName(@PathVariable String name) {
        return catRepository.findByName(name);
    }
}
