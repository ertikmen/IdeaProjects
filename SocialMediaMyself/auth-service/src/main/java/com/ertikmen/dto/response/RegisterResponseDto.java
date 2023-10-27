package com.ertikmen.dto.response;

import com.ertikmen.repository.enums.ERole;
import com.ertikmen.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String activationCode;

}
