package com.code.to.vote.codeToVote.api;

import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.service.UsersService;
import com.code.to.vote.codeToVote.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9006")
@RestController
@RequestMapping("/user")
public class UsersApi {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    UserEntity saveUser(@RequestBody UserEntity userEntity) throws Exception {
        return usersService.saveUser(userEntity);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Boolean deleteUser(@PathVariable Long userId) throws Exception {
        return usersService.deleteUser(userId);
    }

    @RequestMapping(value = "/returnAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<UserEntity> returnAll() throws Exception {
        return usersService.returnAll();
    }

    @RequestMapping(value = "/returnById/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Optional<UserEntity> returnById(@PathVariable Long userId) throws Exception {
        return usersService.returnById(userId);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    UserEntity login(@RequestBody UserEntity userEntity) throws Exception {
        return usersService.loginUser(userEntity);
    }
}
