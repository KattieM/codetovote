package com.code.to.vote.codeToVote.domain;

import javax.persistence.*;

@Entity
@Table(name = "problems")
public class ProblemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public ProblemEntity() {
    }

    public ProblemEntity(String name) {
        this.name = name;
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
}
