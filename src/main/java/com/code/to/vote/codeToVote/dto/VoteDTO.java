package com.code.to.vote.codeToVote.dto;

public class VoteDTO {
    private Long potentialProblemId;
    private Long userId;

    public VoteDTO() {
    }

    public VoteDTO(Long potentialProblemId, Long userId) {
        this.potentialProblemId = potentialProblemId;
        this.userId = userId;
    }

    public Long getPotentialProblemId() {
        return potentialProblemId;
    }

    public void setPotentialProblemId(Long potentialProblemId) {
        this.potentialProblemId = potentialProblemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
