package com.example.inbox10Awards.modules.loginModule;

import com.example.inbox10Awards.modules.authenticationModule.AuthenticationEntity;
import com.example.inbox10Awards.modules.authenticationModule.AuthenticationRepository;
import com.example.inbox10Awards.security.JwtResponse;
import com.example.inbox10Awards.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@CrossOrigin
//@RequestMapping("inbox10/")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private LoginServices loginServices;
    @Autowired
    private AuthenticationRepository authenticationRepository;

///inbox10/registration
    @PostMapping("/inbox10/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginCreditialsDTO userLoginCreditialsDTO) throws Exception {

        AuthenticationEntity authenticationEntity = authenticationRepository.findByEmail(userLoginCreditialsDTO.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

       if(passwordEncoder.matches(userLoginCreditialsDTO.getPassword(), authenticationEntity.getPassword())){
           authenticate(userLoginCreditialsDTO.getEmail(), userLoginCreditialsDTO.getPassword());
           final UserDetails userDetails = loginServices
                   .loadUserByUsername(userLoginCreditialsDTO.getEmail());
           final String token = jwtTokenUtil.generateToken(userDetails);
           return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Optional.of("invalid login details"));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
