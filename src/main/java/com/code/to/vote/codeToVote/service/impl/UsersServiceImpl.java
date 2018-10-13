package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.dao.UsersRepository;
import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) throws Exception {
        return usersRepository.save(userEntity);
    }

    @Override
    public Boolean deleteUser(Long userId) throws Exception {
        usersRepository.deleteById(userId);
        return !usersRepository.existsById(userId);
    }

    @Override
    public Iterable<UserEntity> returnAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<UserEntity> returnById(Long id) {
        return usersRepository.findById(id);
    }
}
