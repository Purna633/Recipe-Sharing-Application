package com.purna.recipe_shearing.repository;

import com.purna.recipe_shearing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
