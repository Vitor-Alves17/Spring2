package com.list.todolist2.services;

import com.list.todolist2.dto.UserRequestDTO;
import com.list.todolist2.dto.UserResponseDTO;
import com.list.todolist2.entities.User;
import com.list.todolist2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    public Optional<UserResponseDTO> buscarPorId(int id){
//        List<User> users = userRepository.findById(id);
//        List<UserResponseDTO> userResponseDTOs = users.stream().map(UserResponseDTO::new).collect(toList());
//        return userResponseDTOs.stream().findFirst();
//    }
    public List<UserResponseDTO> mostrarTudo(){
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTO = users.stream().map(UserResponseDTO::new).collect(toList());

//        for (User user : users) {
//            userResponseDTO.add(new UserResponseDTO(user));
//        }
        return userResponseDTO;
    }

    public UserResponseDTO save(UserRequestDTO user) {
        User u = new User(user.getUsername(), user.getEmail(), user.getPassword());
        userRepository.save(u);
        UserResponseDTO userResponseDTO = new UserResponseDTO(u);
        return userResponseDTO;
    }


    public ResponseEntity<?> login(UserRequestDTO user) {
        User findUser = userRepository.findByEmail(user.getEmail());
        if (findUser == null) {
            return ResponseEntity.ok("Usuario não encontrado!");
        }else {
            if (user.getPassword().equals(findUser.getPassword())) {
                return ResponseEntity.ok("Login com sucesso!");
            }else {
                return ResponseEntity.ok("Senha Incorreta!");
            }
        }
    }

    public String deletarPorId(int id) {
        if (!userRepository.existsById(id)) {
            return "Usuario não encontrado";
        } else {
            userRepository.deleteById(id);
            if (!userRepository.existsById(id)) {
                return "Usuario deletado com sucesso";
            } else {
                return  "Usuario não deletado";
            }
        }
    }


    public String atualizarPorId(int id, @RequestBody UserRequestDTO user) {
        Optional<User> UserExisty = userRepository.findById(id);

        if (UserExisty.isPresent()) {
            User u = UserExisty.get();
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            userRepository.save(u);
            return "Usuario atualizado com sucesso";
        }else {
            return "Usuario não encontrado";
        }
    }
}

