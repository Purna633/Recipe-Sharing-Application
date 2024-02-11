package com.purna.recipe_shearing.service;

import com.purna.recipe_shearing.model.User;

public interface UserService {
    public User findUserById(long userId) throws Exception;
    public User findUserByJwt(String jwt) throws  Exception;
}
