package com.code.to.vote.codeToVote.dao;

import com.code.to.vote.codeToVote.domain.ProblemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProblemsRepository extends CrudRepository<ProblemEntity, Long>{
}
