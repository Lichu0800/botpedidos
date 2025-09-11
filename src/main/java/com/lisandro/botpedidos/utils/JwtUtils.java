package com.lisandro.botpedidos.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtils {
    @Value("${security.jwt.private.key}")
    private String privateKey;
    @Value("${security.jwt.user.generator}")
    private String userGenerator;


    //Crear el Token
    public String createToken(Authentication authentication){
        //Definir el tipo de algoritmo
        Algorithm algorithm = Algorithm.HMAC256(privateKey);
        //Obtener el usuario
        String username = (String) authentication.getPrincipal();

        // Obtener los roles/permisos
        //String authorities = authentication.getAuthorities();

        return null;
    }

    // Validar Token

    //Obtener el usuario

}
