package com.todolist.lab_todolist.service.validation;

import com.todolist.lab_todolist.model.Task;

public class StatusValidation implements TaskValidation {

    @Override
    public void validate(Task task) throws Exception {
        if (task.getStatus() == null || task.getStatus().isBlank()) {
            throw new Exception("Status é obrigatório");
        }
    } 
}
