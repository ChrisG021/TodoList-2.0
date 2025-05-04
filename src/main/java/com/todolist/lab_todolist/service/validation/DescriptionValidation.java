package com.todolist.lab_todolist.service.validation;

import org.springframework.stereotype.Component;

import com.todolist.lab_todolist.model.Task;

@Component
public class DescriptionValidation implements TaskValidation {

    @Override
    public void validate(Task task) throws Exception {
        if (task.getDescription() == null || task.getDescription().isBlank()) {
            throw new Exception("Descrição é obrigatório");
        }
    }
    
}
