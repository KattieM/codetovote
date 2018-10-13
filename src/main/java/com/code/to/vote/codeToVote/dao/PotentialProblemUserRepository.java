package com.code.to.vote.codeToVote.dao;

import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import com.code.to.vote.codeToVote.domain.PotentialProblemUserEntity;
import com.code.to.vote.codeToVote.domain.PotentialProblemUserKey;
import org.springframework.data.repository.CrudRepository;

public interface PotentialProblemUserRepository extends CrudRepository<PotentialProblemUserEntity, PotentialProblemUserKey>{
        public Iterable<PotentialProblemUserEntity> findAllByPotentialProblemEntity(PotentialProblemEntity potentialProblemEntity);
}
