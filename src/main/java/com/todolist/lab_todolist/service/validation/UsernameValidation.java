package com.todolist.lab_todolist.service.validation;

import javax.naming.directory.InvalidAttributesException;

import com.todolist.lab_todolist.model.User;

public class UsernameValidation implements UserValidation {

    @Override
    public void validate(User user) throws Exception {
        if (user.getUsername()==null || user.getUsername().isBlank()) {
            throw new InvalidAttributesException("Username invalid");
        }
    }
    
}
