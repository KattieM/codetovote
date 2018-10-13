package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.dao.ProblemsRepository;
import com.code.to.vote.codeToVote.domain.ProblemEntity;
import com.code.to.vote.codeToVote.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProblemsServiceImpl implements ProblemsService {

    @Autowired
    ProblemsRepository problemsRepository;

    @Override
    public ProblemEntity saveProblem(ProblemEntity problemEntity) throws Exception {
        return problemsRepository.save(problemEntity);
    }

    @Override
    public Boolean deleteProblem(Long problemId) throws Exception {
        problemsRepository.deleteById(problemId);
        return !problemsRepository.existsById(problemId);
    }

    @Override
    public Iterable<ProblemEntity> returnAll() {
        return problemsRepository.findAll();
    }

    @Override
    public Optional<ProblemEntity> returnById(Long id) {
        return problemsRepository.findById(id);
    }
}
