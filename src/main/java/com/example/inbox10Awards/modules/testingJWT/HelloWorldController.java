package com.example.inbox10Awards.modules.testingJWT;

import com.example.inbox10Awards.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloWorldController {


    @RequestMapping({ "/hello" })
    public String firstPage(@RequestHeader HashMap<String,String> headers,String body) {
        String username = "";
        try{
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
             username = jwtTokenUtil.getUsernameFromToken(headers.get("authorization").replace("Bearer",""));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "Hello World"+username;
    }
}
