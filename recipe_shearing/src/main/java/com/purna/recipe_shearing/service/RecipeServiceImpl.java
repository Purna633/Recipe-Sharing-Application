package com.purna.recipe_shearing.service;

import com.purna.recipe_shearing.model.Recipe;
import com.purna.recipe_shearing.model.User;
import com.purna.recipe_shearing.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl  implements RecipeService{
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {
        Recipe createdRecipe=new Recipe();
        createdRecipe.setTitle(recipe.getTitle());
        createdRecipe.setImage(recipe.getImage());
        createdRecipe.setDescription(recipe.getDescription());
        createdRecipe.setUser(recipe.getUser());
        createdRecipe.setCreatedAt(LocalDateTime.now());
        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipeById(long id) throws Exception {
        Optional<Recipe> opt=recipeRepository.findById(id);
        if(opt.isPresent())
        {
            return opt.get();
        }
        throw new Exception("recipe nit found with this is"+id);
    }

    @Override
    public void deleteRecipe(long id) throws Exception {
        findRecipeById(id);
        recipeRepository.deleteById(id);

    }

    @Override
    public Recipe updateRecipe(Recipe recipe, long Id) throws Exception {
        Recipe oldRecipe=findRecipeById(Id);
        if(recipe.getTitle()!=null){
            oldRecipe.setTitle(recipe.getTitle());
        }
        if(recipe.getImage()!=null)
        {
            oldRecipe.setImage(recipe.getImage());
        }
        if(recipe.getDescription()!=null)
        {
            oldRecipe.setDescription(recipe.getDescription());
        }

        return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe likeRecipe(long recipeId, User user) throws Exception {
        Recipe recipe=findRecipeById(recipeId);
        if(recipe.getLikes().contains(user.getId())){
            recipe.getLikes().remove(user.getId());
        }
        else{
            recipe.getLikes().add(user.getId());
        }
        return recipeRepository.save(recipe);
    }
}
