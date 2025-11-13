package com.list.todolist2.dto;


import com.list.todolist2.entities.User;

public class UserResponseDTO {

    private String username;
    private String email;

    public UserResponseDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }



    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
