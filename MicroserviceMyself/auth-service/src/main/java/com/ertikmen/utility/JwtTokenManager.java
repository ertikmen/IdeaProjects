package com.ertikmen.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class JwtTokenManager {

    @Value("${jwt.secretKey}")
    String secretKey;

    @Value("${jwt.issuer}")
    String issuer;

    public Optional<String> createToken(Long id) {

        String token = null;
        Date date = new Date(System.currentTimeMillis() + (1000 * 60 * 15));

        try {
            token = JWT.create()
                    .withIssuer(issuer)
                    .withClaim("myId", id)
                    .withIssuedAt(date)
                    .sign(Algorithm.HMAC512(secretKey));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.ofNullable(token);


    }


}
