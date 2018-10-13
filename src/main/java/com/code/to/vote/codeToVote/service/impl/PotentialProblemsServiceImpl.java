package com.code.to.vote.codeToVote.service.impl;

import com.code.to.vote.codeToVote.dao.PotentialProblemUserRepository;
import com.code.to.vote.codeToVote.dao.PotentialProblemsRepository;
import com.code.to.vote.codeToVote.dao.UsersRepository;
import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import com.code.to.vote.codeToVote.domain.PotentialProblemUserEntity;
import com.code.to.vote.codeToVote.domain.PotentialProblemUserKey;
import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.dto.PotentialProblemDTO;
import com.code.to.vote.codeToVote.dto.VoteDTO;
import com.code.to.vote.codeToVote.service.PotentialProblemsService;
import com.code.to.vote.codeToVote.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PotentialProblemsServiceImpl implements PotentialProblemsService {

    @Autowired
    PotentialProblemsRepository potentialProblemsRepository;
    @Autowired
    PotentialProblemUserRepository potentialProblemUserRepository;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public PotentialProblemEntity savePotentialProblem(PotentialProblemEntity potentialProblemEntity) throws Exception {
        PotentialProblemEntity potentialProblemEntity1 = potentialProblemsRepository.save(potentialProblemEntity);
        PotentialProblemUserEntity potentialProblemUserEntity = new PotentialProblemUserEntity();
        PotentialProblemUserKey potentialProblemUserKey = new PotentialProblemUserKey();
        System.out.println(potentialProblemEntity1.getUserEntity().getUsername()+" "+potentialProblemEntity1.getUserEntity().getPassword()+" "+potentialProblemEntity1.getUserEntity().getId());
        potentialProblemUserKey.setPotentialProblemId(potentialProblemEntity1.getId());
        potentialProblemUserKey.setUserId(potentialProblemEntity1.getUserEntity().getId());
        potentialProblemUserEntity.setId(potentialProblemUserKey);
        potentialProblemUserEntity.setUserEntity(potentialProblemEntity1.getUserEntity());
        potentialProblemUserEntity.setPotentialProblemEntity(potentialProblemEntity1);
        potentialProblemUserRepository.save(potentialProblemUserEntity);
        return potentialProblemEntity1;
    }

    @Override
    public Boolean deletePotentialProblem(Long problemId) throws Exception {
        PotentialProblemEntity potentialProblemEntity = potentialProblemsRepository.findById(problemId).get();
        Iterable<PotentialProblemUserEntity> allVotes = potentialProblemUserRepository.findAllByPotentialProblemEntity(potentialProblemEntity);
        for (PotentialProblemUserEntity potentialProblemUserEntity:allVotes) {
            potentialProblemUserRepository.delete(potentialProblemUserEntity);
        }
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

    @Override
    public boolean voteForProgram(VoteDTO voteDTO) {
        PotentialProblemUserEntity potentialProblemUserEntity = new PotentialProblemUserEntity();
        PotentialProblemUserKey potentialProblemUserKey = new PotentialProblemUserKey();
        potentialProblemUserKey.setUserId(voteDTO.getUserId());
        potentialProblemUserKey.setPotentialProblemId(voteDTO.getPotentialProblemId());
        potentialProblemUserEntity.setUserEntity(usersRepository.findById(voteDTO.getUserId()).get());
        potentialProblemUserEntity.setPotentialProblemEntity(potentialProblemsRepository.findById(voteDTO.getPotentialProblemId()).get());
        potentialProblemUserEntity.setId(potentialProblemUserKey);

        PotentialProblemUserEntity saved = potentialProblemUserRepository.save(potentialProblemUserEntity);
        if(saved!=null)
            return true;
        return false;
    }

    public boolean unvoteForProgram(VoteDTO voteDTO) {
        PotentialProblemUserKey potentialProblemUserKey = new PotentialProblemUserKey();
        potentialProblemUserKey.setUserId(voteDTO.getUserId());
        potentialProblemUserKey.setPotentialProblemId(voteDTO.getPotentialProblemId());
        potentialProblemUserRepository.deleteById(potentialProblemUserKey);
        return !potentialProblemUserRepository.existsById(potentialProblemUserKey);
    }
}
