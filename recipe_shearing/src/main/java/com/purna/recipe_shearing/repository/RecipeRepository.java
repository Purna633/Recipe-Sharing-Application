package com.purna.recipe_shearing.repository;

import com.purna.recipe_shearing.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

}
