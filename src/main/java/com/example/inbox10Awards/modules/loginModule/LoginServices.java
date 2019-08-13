package com.example.inbox10Awards.modules.loginModule;

import com.example.inbox10Awards.modules.authenticationModule.AuthenticationEntity;
import com.example.inbox10Awards.modules.authenticationModule.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LoginServices implements UserDetailsService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<AuthenticationEntity> authenticationEntity = authenticationRepository.findByEmail(email);
        authenticationEntity.orElseThrow(() -> new UsernameNotFoundException("No user found with username " + email));

      //  return new User(authenticationEntity.get().getEmail(),authenticationEntity.get().getPassword());

            return new org.springframework.security.core.userdetails.User(authenticationEntity.get().getEmail(),
                authenticationEntity.get().getPassword(), new ArrayList<>());
    }
}
