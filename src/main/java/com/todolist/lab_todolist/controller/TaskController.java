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

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@RequestBody Task task) throws Exception{
        return service.create(task);
    }

    @GetMapping
    public List<Task> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id")Long id, @RequestBody Task task){
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteTask(id);
    }
}
