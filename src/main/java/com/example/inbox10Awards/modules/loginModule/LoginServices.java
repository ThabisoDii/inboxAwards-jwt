package com.example.inbox10Awards.modules.loginModule;

import com.example.inbox10Awards.modules.authenticationModule.AuthenticationEntity;
import com.example.inbox10Awards.modules.authenticationModule.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LoginServices implements UserDetailsService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        System.out.println("validating got in..."+email);
        if(true){
            System.out.println("validating got in...");
            return new User(email,"$2a$10$4ou0VSQ7SQxfy3dxHrzoTO7my/tnQGZX7MP0hDy8ORgRjRxziXiCi",new ArrayList<>());
        }else {
            throw  new UsernameNotFoundException("User not found");
        }

    }
}
