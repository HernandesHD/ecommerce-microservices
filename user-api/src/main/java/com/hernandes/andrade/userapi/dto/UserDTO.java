package com.hernandes.andrade.userapi.dto;

import com.hernandes.andrade.userapi.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String name;
    @NotBlank(message = "CPF é obrigatório.")
    private String cpf;
    private String address;
    @NotBlank(message = "E-mail é obrigatório")
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setCpf(user.getCpf());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

}
