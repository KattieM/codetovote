package com.code.to.vote.codeToVote.dao;

import com.code.to.vote.codeToVote.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    public UserEntity findByUsername(String username);
}
