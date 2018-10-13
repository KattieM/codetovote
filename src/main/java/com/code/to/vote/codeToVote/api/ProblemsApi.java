package com.code.to.vote.codeToVote.api;

import com.code.to.vote.codeToVote.domain.PotentialProblemEntity;
import com.code.to.vote.codeToVote.domain.ProblemEntity;
import com.code.to.vote.codeToVote.dto.PotentialProblemDTO;
import com.code.to.vote.codeToVote.service.PotentialProblemsService;
import com.code.to.vote.codeToVote.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9006")
@RestController
@RequestMapping("/problems")
public class ProblemsApi {
    @Autowired
    private ProblemsService problemsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProblemEntity saveProblem(@RequestBody ProblemEntity problemEntity) throws Exception {
        return problemsService.saveProblem(problemEntity);
    }

    @RequestMapping(value = "/delete/{problemId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Boolean deleteProblem(@PathVariable Long problemId) throws Exception {
        return problemsService.deleteProblem(problemId);
    }

    @RequestMapping(value = "/returnAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<ProblemEntity> returnAll() throws Exception {
        return problemsService.returnAll();
    }

    @RequestMapping(value = "/returnById/{problemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Optional<ProblemEntity> returnById(@PathVariable Long problemId) throws Exception {
        return problemsService.returnById(problemId);
    }
}
