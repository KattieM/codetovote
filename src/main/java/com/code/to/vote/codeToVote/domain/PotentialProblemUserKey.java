package com.code.to.vote.codeToVote.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PotentialProblemUserKey implements Serializable{


    @Column(name = "potentialProblemId")
    private Long potentialProblemId;

    @Column(name = "userId")
    private Long userId;

    public PotentialProblemUserKey() {
    }

    public PotentialProblemUserKey(Long potentialProblemId, Long userId) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PotentialProblemUserKey that = (PotentialProblemUserKey) o;
        return Objects.equals(potentialProblemId, that.potentialProblemId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(potentialProblemId, userId);
    }
}
