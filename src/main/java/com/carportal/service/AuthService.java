package com.carportal.service;

import com.carportal.entity.User;
import com.carportal.payload.LoginDto;
import com.carportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(LoginDto dto) {
        Optional<User> opUser = userRepository.findByUsername(dto.getUsername());
        if (opUser.isPresent()) {
            User user = opUser.get();
            boolean status = BCrypt.checkpw(dto.getPassword(), user.getPassword());
            return status;
        }
        return false;
    }
}
