package com.purna.recipe_shearing.controller;

import com.purna.recipe_shearing.model.Recipe;
import com.purna.recipe_shearing.model.User;
import com.purna.recipe_shearing.service.RecipeService;
import com.purna.recipe_shearing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe ,
                               @RequestHeader("Authorization") String jwt)throws Exception
    {
        User user=userService.findUserByJwt(jwt);
        recipe.setUser(user);
        Recipe createdRecipe=recipeService.createRecipe(recipe, user);
        return createdRecipe;
    }
    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe , @PathVariable long id)throws Exception
    {

        Recipe updatedRecipe=recipeService.updateRecipe(recipe, id);
        return updatedRecipe;
    }
    @GetMapping()
    public List<Recipe> getAllRecipe()throws Exception
    {
        List<Recipe> recipes=recipeService.findAllRecipe();
        return recipes;
    }
    @DeleteMapping("/{recipeId}")
    public String deleteRecipe( @PathVariable long recipeId)throws Exception
    {
        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
    }
    @PutMapping("/{id}/like")
    public Recipe likeRecipe(@RequestHeader("Authorization")String jwt,
                             @PathVariable long id)throws Exception
    {
        User user=userService.findUserByJwt(jwt);

        Recipe likedRecipe=recipeService.likeRecipe(id, user);
        return likedRecipe;
    }
    

}
