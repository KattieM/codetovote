package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.domain.UserEntity;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public class TokenProcessingService {
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

    @Autowired
    private TokenHandler tokenHandler;

    public String createToken(UserEntity user) throws JsonProcessingException
    {
        if(user == null)
            return null;
        String token = tokenHandler.createToken(user);
        System.out.println("token: " + token);
        return token;
    }

    public UserEntity authenticateRequest(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException
    {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        System.out.println("TOKEN: " + token );
        if(token == null)
            return null;
        UserEntity user = tokenHandler.processToken(token);
        if(user == null)
            return null;
        return user;
    }

}
