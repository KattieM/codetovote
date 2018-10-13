package com.code.to.vote.codeToVote.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PotentialProblems")
public class PotentialProblemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column (name = "date_created")
    private Date dateCreated = new Date();

    @ManyToOne
    @JoinColumn (name = "created_by")
    private UserEntity userEntity;

    @Column(name = "converted_to_problem")
    private boolean converted;

    public PotentialProblemEntity() {
    }

    public PotentialProblemEntity(String name, String description, Date dateCreated, UserEntity userEntity, boolean converted) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.userEntity = userEntity;
        this.converted = converted;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


}
