package com.todolist.lab_todolist.service.validation;

import org.springframework.stereotype.Component;

import com.todolist.lab_todolist.model.Task;

@Component
public class TitleValidation implements TaskValidation {

    @Override
    public void validate(Task task) throws Exception {
        if(task.getTitle()== null || task.getTitle().isBlank()){
            throw new Exception("Título é obrigatório");
        }
    }
        
}
