package com.code.to.vote.codeToVote.api;

import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.dto.PotentialProblemDTO;
import com.code.to.vote.codeToVote.service.PotentialProblemsService;
import com.code.to.vote.codeToVote.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9006")
@RestController
@RequestMapping("/potentialproblems")
public class PotentialProblemsApi {
    @Autowired
    private PotentialProblemsService potentialProblemsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    PotentialProblemEntity savePotentialProblem(@RequestBody PotentialProblemEntity potentialProblemEntity) throws Exception {
        return potentialProblemsService.savePotentialProblem(potentialProblemEntity);
    }

    @RequestMapping(value = "/delete/{problemId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Boolean deletePotentialProblem(@PathVariable Long problemId) throws Exception {
        return potentialProblemsService.deletePotentialProblem(problemId);
    }

    @RequestMapping(value = "/returnAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<PotentialProblemDTO> returnAll() throws Exception {
        return potentialProblemsService.returnAll();
    }

    @RequestMapping(value = "/returnById/{problemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    PotentialProblemDTO returnById(@PathVariable Long problemId) throws Exception {
        return potentialProblemsService.returnById(problemId);
    }
}
