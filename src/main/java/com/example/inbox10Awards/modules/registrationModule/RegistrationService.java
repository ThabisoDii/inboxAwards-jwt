package com.example.inbox10Awards.modules.registrationModule;


import com.example.inbox10Awards.modules.authenticationModule.AuthenticationEntity;
import com.example.inbox10Awards.modules.authenticationModule.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private AuthenticationRepository authenticationRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Optional<?>> saveUser(UserRegistrationDTO userRegistrationDTO) {

        try {

            AuthenticationEntity authenticationEntity = new AuthenticationEntity();
            authenticationEntity.setEmail(userRegistrationDTO.getEmail());
            authenticationEntity.setRole(userRegistrationDTO.getUserType());
            authenticationEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userRegistrationDTO.getEmail());
            userEntity.setName(userRegistrationDTO.getName());
            userEntity.setSurname(userRegistrationDTO.getSurname());

            authenticationEntity.setUserEntity(userEntity);
            authenticationRepository.save(authenticationEntity);


        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.of(""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(Optional.of(""));
    }

}
