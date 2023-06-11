package com.example.resq.Controllers;

import com.example.resq.Util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class Test {
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/private-api")
    public ResponseEntity<String> privateApi(@RequestParam("Authorization") String token) throws Exception {
        System.out.println("Token recibido: " + token);
        try {
            jwtUtils.verify(token);
            return ResponseEntity.ok("Ok");
        }catch(Exception e){
            System.out.println("Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
