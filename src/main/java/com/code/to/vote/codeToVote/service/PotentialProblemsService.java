package com.code.to.vote.codeToVote.service;

import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.dto.PotentialProblemDTO;
import com.code.to.vote.codeToVote.dto.VoteDTO;

import java.util.Optional;

public interface PotentialProblemsService {
    public PotentialProblemEntity savePotentialProblem(PotentialProblemEntity potentialProblemEntity) throws Exception;
    public Boolean deletePotentialProblem(Long problemId) throws Exception;
    public Iterable<PotentialProblemDTO> returnAll();
    public PotentialProblemDTO returnById(Long problemId);
    public boolean voteForProgram(VoteDTO voteDTO);
    public boolean unvoteForProgram(VoteDTO voteDTO);
}
