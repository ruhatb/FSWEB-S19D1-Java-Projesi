package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private int status;
    private LocalDateTime dateTime;
}
