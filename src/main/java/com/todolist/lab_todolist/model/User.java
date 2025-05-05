package com.todolist.lab_todolist.model;



import jakarta.persistence.*;

@Entity(name = "tab_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String telephoneNumber;
    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Task> tasks;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    // public List<Task> getTasks() {
    //     return tasks;
    // }
    // public void setTasks(List<Task> tasks) {
    //     this.tasks = tasks;
    // }


}