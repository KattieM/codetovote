package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.dao.PotentialProblemUserRepository;
import com.code.to.vote.codeToVote.domain.PotentialProblemUserEntity;
import com.code.to.vote.codeToVote.service.PotentialProblemsUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotentialProblemUsersServiceImpl implements PotentialProblemsUsersService{
    @Autowired
    private PotentialProblemUserRepository potentialProblemUserRepository;
    @Override
    public PotentialProblemUserEntity savePotentialProblemUserEntity(PotentialProblemUserEntity potentialProblemUserEntity) {
        return potentialProblemUserRepository.save(potentialProblemUserEntity);
    }

    @Override
    public void delete(PotentialProblemUserEntity potentialProblemUserEntity) {
        potentialProblemUserRepository.delete(potentialProblemUserEntity);
    }
}
