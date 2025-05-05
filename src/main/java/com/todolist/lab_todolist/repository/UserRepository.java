package com.todolist.lab_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.lab_todolist.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
