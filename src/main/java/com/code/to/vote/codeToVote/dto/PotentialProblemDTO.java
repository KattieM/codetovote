package com.code.to.vote.codeToVote.dto;

import com.code.to.vote.codeToVote.domain.PotentialProblemUserEntity;
import com.code.to.vote.codeToVote.domain.UserEntity;

import java.util.Date;
import java.util.List;

public class PotentialProblemDTO {

    private Long id;
    private String name;
    private String description;
    private Date dateCreated;
    private UserEntity userEntity;
    private boolean converted;
    private List<PotentialProblemUserEntity> votes;

    public PotentialProblemDTO() {
    }

    public PotentialProblemDTO(Long id, String name, String description, Date dateCreated, UserEntity userEntity, boolean converted, List<PotentialProblemUserEntity> votes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.userEntity = userEntity;
        this.converted = converted;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    public List<PotentialProblemUserEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<PotentialProblemUserEntity> votes) {
        this.votes = votes;
    }
}
