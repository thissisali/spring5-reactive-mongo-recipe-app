package guru.springframework.repositories.reactive;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeReactiveRepositoryTestIT {

    @Autowired
    RecipeReactiveRepository recipeReactiveRepository;

    @Test
    public void insert() {

        Recipe recipe1 = new Recipe();
        recipe1.setCookTime(3);
        recipe1.setCategories(new HashSet<>());
        recipe1.setDescription("desc");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setImage(new Byte[10]);
        recipe1.setNotes(new Notes());
        recipe1.setPrepTime(14);
        recipe1.setSource("world");
        recipe1.setUrl("dummy.you");

        Recipe recipe2 = new Recipe();
        recipe2.setCookTime(3);
        recipe2.setCategories(new HashSet<>());
        recipe2.setDescription("desc");
        recipe2.setDifficulty(Difficulty.EASY);
        recipe2.setImage(new Byte[10]);
        recipe2.setNotes(new Notes());
        recipe2.setPrepTime(14);
        recipe2.setSource("world");
        recipe2.setUrl("dummy.you");

        recipeReactiveRepository.save(recipe1).block();
        recipeReactiveRepository.save(recipe2).block();

        assertEquals(new Long(4), recipeReactiveRepository.count().block());

    }

}