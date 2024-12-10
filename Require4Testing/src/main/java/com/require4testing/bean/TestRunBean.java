package com.require4testing.bean;

import com.require4testing.entity.TestRun;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional; // Optional, for explicit transaction management
import java.util.List;

@Named
@RequestScoped
public class TestRunBean {

    @PersistenceContext
    private EntityManager em;

    private TestRun testRun = new TestRun();

    public List<TestRun> getAllTestRuns() {
        try {
            return em.createQuery("SELECT tr FROM TestRun tr", TestRun.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Consider throwing a custom exception for better error handling
        }
    }

    @Transactional
    public void saveTestRun() {
        try {
            if (testRun.getId() == null) {
                em.persist(testRun);
            } else {
                em.merge(testRun);
            }
            testRun = new TestRun(); // Reset after saving
        } catch (Exception e) {
            e.printStackTrace();
            // Add error handling logic here
        }
    }

    @Transactional
    public void deleteTestRun(Long id) {
        try {
            TestRun tr = em.find(TestRun.class, id);
            if (tr != null) {
                em.remove(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Add error handling logic here
        }
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }
}
