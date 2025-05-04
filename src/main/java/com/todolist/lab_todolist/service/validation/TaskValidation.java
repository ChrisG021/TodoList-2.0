
package com.todolist.lab_todolist.service.validation;

import com.todolist.lab_todolist.model.Task;

// implementação do strategy por meio dos validates dps facade
public interface TaskValidation{

    void validate(Task task) throws Exception;
    
}