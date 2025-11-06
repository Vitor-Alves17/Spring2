package com.list.todolist2.dto;



public class UserResponseDTO {

    private String username;
    private String email;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
