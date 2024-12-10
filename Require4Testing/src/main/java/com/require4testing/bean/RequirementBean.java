package com.require4testing.bean;

import com.require4testing.entity.Requirement;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import java.util.List;

@Named
@RequestScoped
public class RequirementBean {
    @PersistenceContext
    private EntityManager em;

    private Requirement requirement = new Requirement();

    public List<Requirement> getAllRequirements() {
        return em.createQuery("SELECT r FROM Requirement r", Requirement.class).getResultList();
    }

    public void saveRequirement() {
        if (requirement.getId() == null) {
            em.persist(requirement);
        } else {
            em.merge(requirement);
        }
        requirement = new Requirement();
    }

    public void deleteRequirement(Long id) {
        Requirement r = em.find(Requirement.class, id);
        if (r != null) {
            em.remove(r);
        }
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
}
