package model;

import java.util.Objects;

/**
 * Class realizing entity of Problem
 */
public class Problem {
    private int id;
    private String problem;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Problem)) return false;
        Problem problem1 = (Problem) o;
        return getId() == problem1.getId() &&
                Float.compare(problem1.getPrice(), getPrice()) == 0 &&
                Objects.equals(getProblem(), problem1.getProblem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProblem(), getPrice());
    }
}