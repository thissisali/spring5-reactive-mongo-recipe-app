package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryReactiveRepositoryTestIT {

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;


    @Test
    public void insert() {

        Category category1 = new Category();
        category1.setDescription("bibbidi bobbidi bo");
        category1.setRecipes(new HashSet<>());

        Category category2 = new Category();
        category1.setDescription("bibbidi bobbidi bo");
        category1.setRecipes(new HashSet<>());

        categoryReactiveRepository.save(category1).block();
        categoryReactiveRepository.save(category2).block();

        assertEquals(new Long(6), categoryReactiveRepository.count().block());

    }

}