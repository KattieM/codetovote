package com.code.to.vote.codeToVote.service;

import com.code.to.vote.codeToVote.domain.UserEntity;

import java.util.Optional;

public interface UsersService {
    public UserEntity saveUser(UserEntity userEntity) throws Exception;
    public Boolean deleteUser(Long userId) throws Exception;
    public Iterable<UserEntity> returnAll();
    public Optional<UserEntity> returnById(Long id);
}
