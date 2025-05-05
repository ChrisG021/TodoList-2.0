package com.todolist.lab_todolist.service.validation;

import com.todolist.lab_todolist.model.User;

public interface UserValidation{
        void validate(User user) throws Exception;
}
