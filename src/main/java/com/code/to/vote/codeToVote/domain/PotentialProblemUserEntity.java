package com.code.to.vote.codeToVote.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PotentialProblemsUsers")
public class PotentialProblemUserEntity {

    @EmbeddedId
    private PotentialProblemUserKey id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("potentialProblemId")
    private PotentialProblemEntity potentialProblemEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
    private UserEntity userEntity;

    @Column (name = "day_of_voting")
    private Date dateOfVoting = new Date();

    public PotentialProblemUserEntity(PotentialProblemUserKey id, PotentialProblemEntity potentialProblemEntity, UserEntity userEntity, Date dateOfVoting) {
        this.id = id;
        this.potentialProblemEntity = potentialProblemEntity;
        this.userEntity = userEntity;
        this.dateOfVoting = dateOfVoting;
    }

    public PotentialProblemUserEntity() {
    }

    public PotentialProblemUserKey getId() {
        return id;
    }

    public void setId(PotentialProblemUserKey id) {
        this.id = id;
    }

    public PotentialProblemEntity getPotentialProblemEntity() {
        return potentialProblemEntity;
    }

    public void setPotentialProblemEntity(PotentialProblemEntity potentialProblemEntity) {
        this.potentialProblemEntity = potentialProblemEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getDateOfVoting() {
        return dateOfVoting;
    }

    public void setDateOfVoting(Date dateOfVoting) {
        this.dateOfVoting = dateOfVoting;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PotentialProblemUserEntity that = (PotentialProblemUserEntity) o;
        return Objects.equals(potentialProblemEntity, that.potentialProblemEntity) &&
                Objects.equals(userEntity, that.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(potentialProblemEntity, userEntity);
    }
}
