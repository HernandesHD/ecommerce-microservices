package com.hernandes.andrade.userapi.controller;

import com.hernandes.andrade.userapi.dto.UserDTO;
import com.hernandes.andrade.userapi.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable("cpf") String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Integer id) throws UserPrincipalNotFoundException {
        userService.deleteUser(id);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String name) {
        return userService.findByQueryByName(name);
    }

}
