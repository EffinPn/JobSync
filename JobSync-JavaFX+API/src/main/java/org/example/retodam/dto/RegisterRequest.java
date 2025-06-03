package org.example.retodam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String email;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String apellidos;

    public RegisterRequest(String name, String username, String apellidos, String email, String password) {
        this.name = name;
        this.apellidos = apellidos;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public RegisterRequest() {}

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}