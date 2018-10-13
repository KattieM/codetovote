package com.code.to.vote.codeToVote.dao;

import com.code.to.vote.codeToVote.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

}
