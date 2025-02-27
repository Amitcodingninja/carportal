package com.carportal.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiry-time}")
    private String expiry;

    private Algorithm algorithm;

    @PostConstruct
    public void postConstruct() throws UnsupportedEncodingException {
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generateToken(String username) {
        long expiryMillis = Long.parseLong(expiry); // Convert expiry to long
        return JWT.create()
                .withClaim("name", username)
                .withExpiresAt(Date.from(Instant.now().plusMillis(expiryMillis))) // Use the converted value
                .withIssuer(issuer)
                .sign(algorithm);
    }

    // Trick to remember : Junior Ronaldo is buying vegetable
    public String getUsername(String token) {
        DecodedJWT decodedJwt = JWT.require(algorithm)
                .withIssuer(issuer)
                .build()
                .verify(token);
        return decodedJwt.getClaim("name").asString();
    }


}
// To easily remember this JWT creation flow, use this shortcut mnemonic:
//🔑 "Claim → Expiry → Issuer → Sign" (CEIS) (By Chatgpt)
//Or break it into a simple phrase:"Set Claim, Expire Time, Issuer, then Sign"
