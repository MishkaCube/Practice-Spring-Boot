package com.example.demo.controllers;

import com.example.demo.jwt.JWTUtil;
import com.example.demo.dto.AuthDto;
import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("reg")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserCreateDTO request) {
        return ResponseEntity.ok(userService.signUp(request));
    }

    @PostMapping(value = "/login")
    public Map<String, String> auth(@RequestBody AuthDto request) {

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(request.email(), request.password());

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad credentials");
        }

        String jwt = jwtUtil.generateToken(request.email());
        return Map.of("accessToken", jwt);
    }
}
