package com.todolist.lab_todolist.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.todolist.lab_todolist.exceptions.UserNotFoundException;
import com.todolist.lab_todolist.model.Task;
import com.todolist.lab_todolist.model.User;
import com.todolist.lab_todolist.repository.UserRepository;
import com.todolist.lab_todolist.service.validation.UserValidation;

@Service
public class UserService {
    public UserRepository repository;
    public List<Task> tasks;
    private final List<UserValidation> validations;


    public UserService(UserRepository repository, List<Task> tasks, List<UserValidation> validations) {
        this.repository = repository;
        this.tasks = tasks;
        this.validations = validations;
    }

    //POST
    public User createUser(User user) throws Exception {
        for (UserValidation validation : validations) {
            validation.validate(user);
        }
    
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    //GET/id
    public User getUserById(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        //ele geraria um op task porem com a exceção ele retorn ou user ou a esxceção
    }

    //PUT/id
    public User updateUserById(Long id, User updatedUser) {
        User findUser = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        findUser.setUsername(updatedUser.getUsername());
        findUser.setTelephoneNumber(updatedUser.getTelephoneNumber());

        System.out.println("ATUALIZANDO USER ID :"+id);

        return repository.save(findUser);
    }

    public void deleteById(Long id){
        if (!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        System.out.println("DELETANDO USER ID:"+id);
        repository.deleteById(id);

    }

    
}
