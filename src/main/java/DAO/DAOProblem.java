package dao;

import model.Problem;

public interface DAOProblem extends DAO <Problem, Integer> {
    public Problem getProblemByPrice(Float priceMin, Float priceMax);
}
