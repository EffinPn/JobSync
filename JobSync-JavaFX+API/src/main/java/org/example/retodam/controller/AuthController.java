package org.example.retodam.controller;

import org.example.retodam.dto.LoginRequest;
import org.example.retodam.dto.LoginResponse;
import org.example.retodam.dto.RegisterRequest;
import org.example.retodam.model.Usuario;
import org.example.retodam.security.JwtUtil;
import org.example.retodam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UsuarioService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(JwtUtil jwtUtil, UsuarioService userService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = jwtUtil.createToken(auth);

            Integer empresa = null;
            String role = null;
            Object user = auth.getPrincipal();

            if (user instanceof Usuario) {
                Usuario usuario = (Usuario) user;
                empresa = usuario.getIdempresa();
                role = usuario.getRole();
            }

            return ResponseEntity.ok(new LoginResponse(token, empresa, role));
        } catch (Exception e) {
            // Cualquier otro error durante la autenticación
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al logear - " + e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {

        if (userService.existsByUsername(registerRequest.getUsername()) || userService.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error: Usuario o Email en uso.");
        }

        Usuario user = new Usuario(registerRequest.getUsername(),
                registerRequest.getName(),
                registerRequest.getApellidos(),
                registerRequest.getEmail(),
                passwordEncoder.encode(registerRequest.getPassword()),
                new Date());
        user.setRole("USER");

        user.setPerfiles(null);
        user.setSolicitudes(null);
        user.setEnabled(0);

        try {
            userService.registrarUsuario(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }


    }
}
