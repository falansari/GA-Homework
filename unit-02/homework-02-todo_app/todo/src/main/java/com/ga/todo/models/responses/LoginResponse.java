package com.ga.todo.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    /**
     * Error or success message, or JWT token
     */
    private String message;
}
