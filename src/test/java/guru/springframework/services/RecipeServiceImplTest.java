package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp(){
        initMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void testGetRecipes() {
        Recipe recipe=new Recipe();
        HashSet<Recipe> recipeHashSet=new HashSet<>();
        recipeHashSet.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeHashSet);
        assertEquals(recipeHashSet,recipeService.getRecipes());
        Mockito.verify(recipeRepository,Mockito.times(1)).findAll();
    }

    @Test
    public void testGetRecipeById(){
        Recipe recipe=new Recipe();
        recipe.setId(1L);
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));
        assertNotNull(recipeService.findById(1L));
        assertEquals(recipe,recipeService.findById(1L));
    }
}