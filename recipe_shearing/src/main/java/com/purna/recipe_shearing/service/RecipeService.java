package com.purna.recipe_shearing.service;

import com.purna.recipe_shearing.model.Recipe;
import com.purna.recipe_shearing.model.User;

import java.util.List;

public interface RecipeService {
    public Recipe createRecipe(Recipe recipe, User user);
    public Recipe findRecipeById(long id) throws Exception;

    public void deleteRecipe(long id) throws  Exception;
    public Recipe updateRecipe(Recipe recipe, long Id) throws  Exception;
    public List<Recipe> findAllRecipe();
    public Recipe likeRecipe(long recipeId,User user) throws Exception;
}
