package com.todolist.lab_todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todolist.lab_todolist.model.Task;
import com.todolist.lab_todolist.repository.TaskRepository;
import com.todolist.lab_todolist.service.validation.TaskValidation;

@Service
public class TaskService  {

    private final TaskRepository taskRepository;

    private final List<TaskValidation> validations;

    public TaskService(TaskRepository taskRepository, List<TaskValidation> validations) {
        this.taskRepository = taskRepository;
        this.validations = validations;
    }

    //post
    public Task create(Task task) throws Exception {
        for (TaskValidation validation : validations) {
            validation.validate(task); // se falhar, vai lançar Exception e parar aqui
        }
        return taskRepository.save(task);
    }
    // get
    public List<Task> listAll(){
        return taskRepository.findAll();
    }

    //get id
    public Task getById(Long id){
        List<Task> allTasks = taskRepository.findAll();
        Task findTask = null;

        for (Task task : allTasks) {
            if(task.getId() == id){
                findTask = task;
            }
        }
        return findTask;
    }

    //PUT
    public Task updateTask(Long id, Task updateTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            
            task.setTitle(updateTask.getTitle());
            task.setDescription(updateTask.getDescription());
            task.setStatus(updateTask.getStatus());

            System.out.println("Atualizado id:" + id);
            
            
            // Salva a tarefa atualizada
            return taskRepository.save(task);
        } else {
            System.out.println("Tarefa não encontrada com id: " + id);
        }
        return updateTask;
    
    }

    //DELETE

    public void deleteTask(Long id){
        System.out.println("Deletand task id: "+id);
        taskRepository.deleteById(id);
    }
}
