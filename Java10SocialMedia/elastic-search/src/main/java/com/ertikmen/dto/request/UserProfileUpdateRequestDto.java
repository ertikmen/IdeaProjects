package com.ertikmen.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileUpdateRequestDto {

    private String token;

    @NotBlank(message = "Kullanıcı adı boş geçilemez...")
    private String username;
    @Email
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String about;
    private String name;
    private String surName;
    private LocalDate birthDate;

}
