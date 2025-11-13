package com.list.todolist2.controller;

import com.list.todolist2.dto.UserRequestDTO;
import com.list.todolist2.dto.UserResponseDTO;
import com.list.todolist2.entities.User;
import com.list.todolist2.repository.UserRepository;
import com.list.todolist2.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "usuario/cadastro")
    public ResponseEntity<?> save(@Valid @RequestBody UserRequestDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PostMapping(value = "user/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(user));
    }

    @GetMapping
    public List<UserResponseDTO> mostrarTudo() {
       return userService.mostrarTudo();
    }
//    @GetMapping(value = "{id}")
//    public Optional<User> buscarPorId(@PathVariable int id){
//        return userService.buscarPorId(id);
//    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable int id) {
        return ResponseEntity.ok(userService.deletarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPorId(@PathVariable int id, @RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.atualizarPorId(id, user));
}
}