package com.code.to.vote.codeToVote.service;

import com.code.to.vote.codeToVote.domain.PotentialProblemUserEntity;


public interface PotentialProblemsUsersService {
    public PotentialProblemUserEntity savePotentialProblemUserEntity(PotentialProblemUserEntity potentialProblemUserEntity);
    public void delete(PotentialProblemUserEntity potentialProblemUserEntity);
}
