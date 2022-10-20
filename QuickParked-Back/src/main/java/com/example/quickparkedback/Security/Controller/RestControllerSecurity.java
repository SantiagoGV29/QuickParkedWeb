package com.example.quickparkedback.Security.Controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking")
public class RestControllerSecurity {
    @Autowired
    JwtEncoder encoder;

    @GetMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4200/"}, methods = {RequestMethod.OPTIONS, RequestMethod.GET})
    public String token(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 12000L;
        // @formatter:off
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        // @formatter:on
        ObjectNode objectNode = new ObjectNode(new JsonNodeFactory(false));
        objectNode.put("token", this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        return objectNode.toPrettyString();
    }
}