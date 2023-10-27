package com.ertikmen.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage {

    private int code;
    private String message;

    @Builder.Default
    private LocalDateTime date=LocalDateTime.now();


}
