package com.todolist.lab_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.lab_todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
    
}
