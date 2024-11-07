package com.hernandes.andrade.userapi.service;

import com.hernandes.andrade.userapi.dto.UserDTO;
import com.hernandes.andrade.userapi.model.User;
import com.hernandes.andrade.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

}
