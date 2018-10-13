package com.code.to.vote.codeToVote.service;

import com.code.to.vote.codeToVote.domain.ProblemEntity;

import java.util.Optional;

public interface ProblemsService {
    public ProblemEntity saveProblem(ProblemEntity problemEntity) throws Exception;
    public Boolean deleteProblem(Long problemId) throws Exception;
    public Iterable<ProblemEntity> returnAll();
    public Optional<ProblemEntity> returnById(Long id);
}
