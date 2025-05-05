package com.todolist.lab_todolist.service.validation;

import javax.naming.directory.InvalidAttributesException;

import com.todolist.lab_todolist.model.User;

public class telephoneValidation implements UserValidation {
    
    @Override
    public void validate(User user) throws Exception {
        if (user.getTelephoneNumber()==null || user.getTelephoneNumber().isBlank()) {
            throw new InvalidAttributesException("Username invalid");
        }
    }
    
}

