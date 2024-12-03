package com.require4testing.controller;

import com.require4testing.model.Requirement;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Named("requirementBean")
@RequestScoped
public class RequirementBean {

    @PersistenceContext
    private EntityManager entityManager;

    private Requirement requirement = new Requirement();

    public String saveRequirement() {
        entityManager.persist(requirement);
        requirement = new Requirement(); // reset the form
        return "listRequirements?faces-redirect=true"; // redirect to list page
    }

    public List<Requirement> getRequirements() {
        return entityManager.createQuery("SELECT r FROM Requirement r", Requirement.class).getResultList();
    }

    // Getter and Setter
    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
}
