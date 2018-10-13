package com.code.to.vote.codeToVote.dao;

import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import org.springframework.data.repository.CrudRepository;

public interface PotentialProblemsRepository extends CrudRepository<PotentialProblemEntity, Long> {
}
