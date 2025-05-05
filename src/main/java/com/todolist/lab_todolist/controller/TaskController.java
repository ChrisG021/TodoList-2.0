package com.todolist.lab_todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.lab_todolist.model.Task;
import com.todolist.lab_todolist.service.TaskService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
    @Tag(name = "Create",description = "Create task and add to Database")
    @PostMapping
    public Task create(@RequestBody Task task) throws Exception{
        return service.create(task);
    }
    @Tag(name = "Find all",description = "Get all task from Database")
    @GetMapping
    public List<Task> listAll(){
        return service.listAll();
    }
    @Tag(name = "Find by ID",description = "Find task ")
    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @Tag(name = "Update",description = "Update task by ID")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id")Long id, @RequestBody Task task){
        return service.updateTask(id, task);
    }

    @Tag(name ="Delete", description = "Delete task by ID")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteTask(id);
    }
}
