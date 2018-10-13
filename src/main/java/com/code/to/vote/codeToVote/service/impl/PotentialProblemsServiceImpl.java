package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.dao.PotentialProblemUserRepository;
import com.code.to.vote.codeToVote.dao.PotentialProblemsRepository;
import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import com.code.to.vote.codeToVote.domain.PotentialProblemUserEntity;
import com.code.to.vote.codeToVote.dto.PotentialProblemDTO;
import com.code.to.vote.codeToVote.service.PotentialProblemsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PotentialProblemsServiceImpl implements PotentialProblemsService {

    @Autowired
    PotentialProblemsRepository potentialProblemsRepository;
    @Autowired
    PotentialProblemUserRepository potentialProblemUserRepository;

    @Override
    public PotentialProblemEntity savePotentialProblem(PotentialProblemEntity potentialProblemEntity) throws Exception {
        return potentialProblemsRepository.save(potentialProblemEntity);
    }

    @Override
    public Boolean deletePotentialProblem(Long problemId) throws Exception {
        potentialProblemsRepository.deleteById(problemId);
        return !potentialProblemsRepository.existsById(problemId);
    }

    @Override
    public List<PotentialProblemDTO> returnAll() {
        Iterable<PotentialProblemEntity> potentialProblemEntityList = potentialProblemsRepository.findAll();
        List<PotentialProblemDTO> potentialProblemDTOS = new LinkedList<>();
        for (PotentialProblemEntity potentialProblemEntity : potentialProblemEntityList) {
            PotentialProblemDTO potentialProblemDTO = new PotentialProblemDTO();
            potentialProblemDTO.setId(potentialProblemEntity.getId());
            potentialProblemDTO.setName(potentialProblemEntity.getName());
            potentialProblemDTO.setDescription(potentialProblemEntity.getDescription());
            potentialProblemDTO.setConverted(potentialProblemEntity.isConverted());
            potentialProblemDTO.setDateCreated(potentialProblemEntity.getDateCreated());
            potentialProblemDTO.setUserEntity(potentialProblemEntity.getUserEntity());
            Iterable<PotentialProblemUserEntity> allVotes = potentialProblemUserRepository.findAllByPotentialProblemEntity(potentialProblemEntity);
            int counter = 0;
            for (PotentialProblemUserEntity potentialProblemUserEntity :
                    allVotes) {
                counter++;
            }
            if (counter > 0) {
                List<PotentialProblemUserEntity> votesForDTO = new LinkedList<>();
                for (PotentialProblemUserEntity potentialProblemUserEntity :
                        allVotes) {
                    votesForDTO.add(potentialProblemUserEntity);
                }
                potentialProblemDTO.setVotes(votesForDTO);
            }
            potentialProblemDTOS.add(potentialProblemDTO);
        }
        if (potentialProblemDTOS.size() > 0)
            return potentialProblemDTOS;
        else
            return null;
    }

    @Override
    public PotentialProblemDTO returnById(Long problemId) {
        Optional<PotentialProblemEntity> potentialProblemEntityFound = potentialProblemsRepository.findById(problemId);
        PotentialProblemDTO potentialProblemDTO = new PotentialProblemDTO();
        if (potentialProblemEntityFound.isPresent()) {
            PotentialProblemEntity potentialProblemEntity = potentialProblemEntityFound.get();
            potentialProblemDTO.setId(potentialProblemEntity.getId());
            potentialProblemDTO.setName(potentialProblemEntity.getName());
            potentialProblemDTO.setDescription(potentialProblemEntity.getDescription());
            potentialProblemDTO.setConverted(potentialProblemEntity.isConverted());
            potentialProblemDTO.setDateCreated(potentialProblemEntity.getDateCreated());
            potentialProblemDTO.setUserEntity(potentialProblemEntity.getUserEntity());
            Iterable<PotentialProblemUserEntity> allVotes = potentialProblemUserRepository.findAllByPotentialProblemEntity(potentialProblemEntity);
            int counter = 0;
            for (PotentialProblemUserEntity potentialProblemUserEntity :
                    allVotes) {
                counter++;
            }
            if (counter > 0) {
                List<PotentialProblemUserEntity> votesForDTO = new LinkedList<>();
                for (PotentialProblemUserEntity potentialProblemUserEntity :
                        allVotes) {
                    votesForDTO.add(potentialProblemUserEntity);
                }
                potentialProblemDTO.setVotes(votesForDTO);
            }
        }
        if (potentialProblemDTO != null) {
            return potentialProblemDTO;
        }
        return null;
    }
}
