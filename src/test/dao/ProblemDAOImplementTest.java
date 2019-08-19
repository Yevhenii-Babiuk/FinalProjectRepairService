package dao;

import model.Problem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProblemDAOImplementTest {
    private ProblemDAOImplement problemDao = new ProblemDAOImplement();
    private Problem problem = new Problem();

    @Before
    public void setProblemBeforeEachTest() {
        problem.setId(2999);
        problem.setPrice(999);
        problem.setProblem("Install new OS");
        problemDao.add(problem);
    }

    @After
    public void deleteBeforeNextTest() {
        problem.setId(2999);
        problemDao.delete(problem);
    }

    @Test
    public void add() {
        problemDao.delete(problem);
        problem.setId(2999);
        problem.setPrice(257);
        problem.setProblem("New screen");
        problemDao.add(problem);
        assertEquals(problem, problemDao.getEntityByKey(2999));
    }

    @Test
    public void getAll() {
        List<Problem> problems=problemDao.getAll();
        assertEquals(problem, problems.get(problems.size()-1));
    }

    @Test
    public void getEntityByKey() {
        assertEquals(problem, problemDao.getEntityByKey(2999));
    }

    @Test
    public void update() {
        problem.setPrice(2834);
        problemDao.update(problem);
        assertEquals(problem, problemDao.getEntityByKey(2999));
    }

    @Test
    public void delete() {
        problemDao.delete(problem);
        assertNull(problemDao.getEntityByKey(2999));
    }

    @Test
    public void getProblemByPrice() {
        List<Problem> problems = problemDao.getProblemByPrice(998F,1000F);
        assertEquals(problem, problems.get(0));
    }

    @Test
    public void getProblemBySolving() {
        assertEquals(problem, problemDao.getProblemBySolving("Install new OS"));
    }
}