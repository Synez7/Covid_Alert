package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserRepository userRepository;
    private static final String uri = "api/v1";

    @GetMapping(uri+"/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping(uri + "/users/{id}") 
    public User get(@PathVariable Long id){
    	
    	if(!userRepository.findById(id).isPresent()){
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND , " User with ID " + id + " not found " ) ;
    	}
        return userRepository.getById(id);
    }

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(uri + "/users")
    public User create(@RequestBody User user){
    	  	
   		return userRepository.saveAndFlush(user);
        
    }

    @RequestMapping(value = uri + "/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @RequestMapping(value = uri + "/users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user){
        User existingUser = userRepository.getById(id);
        BeanUtils.copyProperties(user,existingUser,"user_id");
        return userRepository.saveAndFlush(existingUser);
    }


}
