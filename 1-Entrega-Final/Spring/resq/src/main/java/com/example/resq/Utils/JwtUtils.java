package com.example.resq.Utils;

import com.example.resq.Models.Voluntario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static String secret = "This_is_secret";
    public String generateJwt(Voluntario voluntario){
        Date issuedAt = new Date();
        // Claims
        Claims claims = Jwts.claims()
                .setIssuer(voluntario.getId().toString())
                .setIssuedAt(issuedAt);

        // Generate jwt using claims
        return Jwts.builder().setClaims(claims).compact();
    }

    public String generateJwt2(String id){
        Date issuedAt = new Date();
        // Claims
        Claims claims = Jwts.claims()
                .setIssuer(id)
                .setIssuedAt(issuedAt);

        // Generate jwt using claims
        return Jwts.builder().setClaims(claims).compact();
    }

    public void verify(String autorization) throws Exception {
        System.out.println("JwtUtils.java: verify() -> autorization = " + autorization);
        try{
            Jwts.parser().parseClaimsJwt(autorization);
        }catch(Exception e){
            throw new Exception();
        }
    }
}
