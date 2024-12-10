package com.require4testing.entity;

import jakarta.persistence.*;

@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private Requirement requirement;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
}