package com.hernandes.andrade.userapi.dto;

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

    private String name;
    private String cpf;
    private String endereco;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
}
