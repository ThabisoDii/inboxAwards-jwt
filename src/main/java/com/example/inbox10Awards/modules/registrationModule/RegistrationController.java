package com.example.inbox10Awards.modules.registrationModule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
//@RequestMapping("inbox10/")
@CrossOrigin

public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/inbox10/registration")
    public ResponseEntity<Optional<?>> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO){
        return registrationService.saveUser(userRegistrationDTO);

    }
}
