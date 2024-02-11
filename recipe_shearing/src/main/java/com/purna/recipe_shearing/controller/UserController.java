package com.purna.recipe_shearing.controller;

import com.purna.recipe_shearing.model.User;
import com.purna.recipe_shearing.repository.UserRepository;
import com.purna.recipe_shearing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/api/users/profile")
    public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws  Exception
    {
        User user =userService.findUserByJwt(jwt);
        return user;
    }
    //private UserRepository userRepository;
    /*@PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception
    {
        User isExit=userRepository.findByEmail(user.getEmail());
        if(isExit!=null)
        {
            throw new  Exception ("user has use this email already "+user.getEmail());
        }
        User savedUser = userRepository.save(user);
        return savedUser;

    }*/
    /*@DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable long userId) throws Exception
    {
        userRepository.deleteById(userId);
        return "User deleted successfully";

    }*/
  /*  @GetMapping ("/users")
    public List<User> getallUsers() throws Exception
    {
        List<User>  users=userRepository.findAll();
        return users;

    }*/
    /*public User findByEmail(String email ) throws Exception
    {
        User user=userRepository.findByEmail(email);
        if(user==null)
        {
            throw new  Exception ("user nit found with this email"+email);
        }
        return user;
    }*/
}
