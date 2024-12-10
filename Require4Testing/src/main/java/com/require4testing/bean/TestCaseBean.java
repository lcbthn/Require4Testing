package com.require4testing.bean;

import com.require4testing.entity.TestCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class TestCaseBean {
    @PersistenceContext
    private EntityManager em;

    private TestCase testCase = new TestCase();

    public List<TestCase> getAllTestCases() {
        return em.createQuery("SELECT t FROM TestCase t", TestCase.class).getResultList();
    }

    public void saveTestCase() {
        if (testCase.getId() == null) {
            em.persist(testCase);
        } else {
            em.merge(testCase);
        }
        testCase = new TestCase();
    }

    public void deleteTestCase(Long id) {
        TestCase tc = em.find(TestCase.class, id);
        if (tc != null) {
            em.remove(tc);
        }
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }
}
