package guru.springframework.controller;

import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){
        model.addAttribute("recipesList",recipeService.getRecipes());
        return "index";
    }

    // Load and display data from data.sql file
//    private final CategoryRepository categoryRepository;
//    private final UnitOfMeasureRepository unitOfMeasureRepository;
//
//    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//    }
//
//    @RequestMapping({"","/","/index"})
//    public String getIndex(){
//        Optional<Category> categoryOptional=categoryRepository.findByDescription("Indian");
//        Optional<UnitOfMeasure> unitOfMeasureOptional=unitOfMeasureRepository.findByUom("Teaspoon");
//        System.out.println(categoryOptional.get().getDescription());
//        System.out.println(unitOfMeasureOptional.get().getId());
//        return "index";
//    }

}
