package com.example.treino.services;

import com.example.treino.repositories.SystemOrganizationRepository;
import com.example.treino.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OSService {
    private final UserRepository userRepository;
    private final SystemOrganizationRepository systemOrganizationRepository;


}
