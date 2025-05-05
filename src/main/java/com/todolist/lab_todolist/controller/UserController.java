package com.todolist.lab_todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.todolist.lab_todolist.model.User;
import com.todolist.lab_todolist.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "User Dashboard")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws Exception{
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updatUser(@RequestBody User user,@PathVariable Long id){
        return service.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
