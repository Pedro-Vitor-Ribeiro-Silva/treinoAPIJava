package com.example.treino.services;

import com.example.treino.DTO.LoginDTO;
import com.example.treino.DTO.LoginResponseDTO;
import com.example.treino.DTO.RegisterDTO;
import com.example.treino.models.User;
import com.example.treino.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void register(RegisterDTO data){
       if (userRepository.findByEmail(data.getEmail()).isPresent()) {
           throw new RuntimeException("Não foi possível registrar o usuário. O e-mail já está em uso.");
       }


        String newUserCode;
        do {
            newUserCode = codeGenerator();
        } while (userRepository.findByUserCode(newUserCode).isPresent());

        User newUser = User.builder()
                .name(data.getName())
                .email(data.getEmail())
                .password(data.getPassword())
                .userCode(newUserCode)
                .build();

       userRepository.save(newUser);
    }

    public LoginResponseDTO login(LoginDTO data) {
        User user = userRepository.findByEmail(data.getEmail()).orElseThrow(() ->
                new RuntimeException("Email não encontrado"));
        return new LoginResponseDTO(user.getId(), user.getName(), user.getUserCode());
    }




    private String codeGenerator() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

}
