package guru.springframework.controller;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

//    @Mock
//    HashSet<Recipe> recipesMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("recipes"))
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndex() throws Exception{
        Set<Recipe> recipes=new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe=new Recipe();
        recipe.setId(1L);
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> captor=ArgumentCaptor.forClass(Set.class);

        String viewName = indexController.getIndex(model);

        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),captor.capture());
        Set<Recipe> recipeSet=captor.getValue();
        assertEquals(2,recipeSet.size());
        verify(recipeService, times(1)).getRecipes();

//        verify(model, times(1)).addAttribute(eq("recipes"), same(recipesMock));

    }
}