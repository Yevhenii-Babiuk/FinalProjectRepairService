package dao;

import model.Problem;

import java.util.List;

/**
 * Base interface for DAO layer of Problem
 */

public interface DAOProblem extends DAO <Problem, Integer> {
    public List<Problem> getProblemByPrice(Float priceMin, Float priceMax);
    public Problem getProblemBySolving(String solving);
}
