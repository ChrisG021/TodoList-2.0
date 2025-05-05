package com.todolist.lab_todolist.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Usuário não encontrado com ID: " + id);
    }
}
