package com.smartspend.smartspend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String email;
    private String password;
}
