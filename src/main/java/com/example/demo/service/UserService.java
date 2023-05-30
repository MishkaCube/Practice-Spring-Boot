package com.example.demo.service;

import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserRole;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::entityToUserDto).collect(Collectors.toList());
    }
    public UserDTO signUp(UserCreateDTO request) {
        boolean isUserExists =
                userRepository.findByEmail(request.getEmail())
                        .isPresent();
        if (isUserExists) {
            throw new IllegalStateException("Такой Email уже есть!");
        }
        request.setRole(UserRole.ROLE_USER);
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setIsActive(true);

        userRepository.save(userMapper.userCreateDtoToEntity(request));
        return userMapper.userCreateDtoToDto(request);
    }

}
