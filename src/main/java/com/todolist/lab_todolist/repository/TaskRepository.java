package com.todolist.lab_todolist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.lab_todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<Task> findByTitleAndDescription(String title, String description);
}
