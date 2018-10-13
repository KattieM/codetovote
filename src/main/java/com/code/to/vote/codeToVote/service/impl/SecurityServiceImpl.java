package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.dao.UsersRepository;
import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.service.SecurityService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Service
public class SecurityServiceImpl implements SecurityService{
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokenProcessingService tokenProcessingService;

    public String authenticateUser(UserEntity user) throws JsonProcessingException, Exception {
        UserEntity userDb = usersRepository.findByUsername(user.getUsername());

        if(userDb == null){
            throw new IllegalArgumentException("NO_SUCH_USER");
        }
        //User localUser = users.get(0);

        if(!user.getPassword().equals(userDb.getPassword())){
            throw new Exception();
        }

        return tokenProcessingService.createToken(userDb);
    }

    public UserEntity authenticateHttpRequest(HttpServletRequest httpServletRequest) throws JsonParseException, JsonMappingException, IOException{
        return tokenProcessingService.authenticateRequest(httpServletRequest);
    }

}
