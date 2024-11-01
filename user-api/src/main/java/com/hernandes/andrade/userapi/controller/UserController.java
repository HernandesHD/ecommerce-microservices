package com.hernandes.andrade.userapi.controller;

import com.hernandes.andrade.userapi.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String getMessage() {
        return "Spring Boot is working!";
    }

    public static List<UserDTO> users = new ArrayList<>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Pedro");
        userDTO.setCpf("12345678911");
        userDTO.setAddress("Travessa Fulano 01");
        userDTO.setEmail("pedro@teste.com");
        userDTO.setPhone("22999887766");
        userDTO.setCreatedAt(LocalDateTime.now());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Tiago");
        userDTO2.setCpf("12345678912");
        userDTO2.setAddress("Travessa Fulano 02");
        userDTO2.setEmail("tiago@teste.com");
        userDTO2.setPhone("21999887766");
        userDTO2.setCreatedAt(LocalDateTime.now());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("João");
        userDTO3.setCpf("12345678913");
        userDTO3.setAddress("Avenida A");
        userDTO3.setEmail("joao@teste.com");
        userDTO3.setPhone("22988776655");
        userDTO3.setCreatedAt(LocalDateTime.now());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/{cpf}")
    public UserDTO getFilterUser(@PathVariable String cpf) {
        return users
                .stream()
                .filter(userDTO -> userDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody @Valid UserDTO userDTO) {
        userDTO.setCreatedAt(LocalDateTime.now());
        users.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/delete/{cpf}")
    public boolean deleteUser(@PathVariable String cpf) {
        return users
                .removeIf(userDTO -> userDTO.getCpf().equals(cpf));
    }

}
