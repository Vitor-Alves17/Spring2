package com.list.todolist2.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;


public class UserRequestDTO {

    @NotBlank(message = "Coloca essa porra, caralho")
    private String username;
    @Email @Column(unique = true)
    @NotBlank(message = "Coloca essa porra, caralho")
    private String email;
    @NotBlank(message = "Coloca essa porra, caralho")
    @Size(min = 8, max = 20, message = "Tem que colocar no tamanho da tua pica, média")
    private String password;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
