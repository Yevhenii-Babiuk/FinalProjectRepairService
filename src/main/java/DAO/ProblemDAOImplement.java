package DAO;

import Model.Problem;
import Util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAOImplement extends MySQLConnector implements DAO <Problem, Integer> {

    private Problem setProblemFromDb(ResultSet resultSet) {
        Problem problem = new Problem();
        try {
            problem.setId(resultSet.getInt("id"));
            problem.setProblem(resultSet.getString("problem"));
            problem.setProblemType(resultSet.getInt("problem_type"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return problem;
    }

    private void setProblemToDb(PreparedStatement preparedStatement, Problem entity) {
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getProblem());
            preparedStatement.setInt(3, entity.getProblemType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Problem getProblemFromDb(String sql, Integer id) {
        Problem problem = new Problem();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            problem = setProblemFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return problem;
    }

    @Override
    public void add(Problem entity) {
        String sql = "INSERT INTO `problem` (id, problem, problem_type) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setProblemToDb(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public List<Problem> getAll() {
        List<Problem> problemList = new ArrayList<>();
        String sql = "SELECT id, problem, problem_type FROM `problem`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Problem problem = setProblemFromDb(resultSet);
                problemList.add(problem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return problemList;
    }

    @Override
    public Problem getEntityByKey(Integer id) {
        String sql = "SELECT id, problem, problem_type FROM `problem` WHERE id = ?";
        return getProblemFromDb(sql, id);
    }

    @Override
    public void update(Problem entity) {
        String sql = "UPDATE `problem` SET id=?, problem=?, problem_type=? WHERE id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setProblemToDb(preparedStatement, entity);
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Problem entity) {
        String sql = "DELETE  FROM `problem` WHERE id=?";
        PreparedStatement preparedStatement =getPrepareStatement(sql);

        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public Problem getProblemByType(Integer type) {
        String sql = "SELECT id, problem, problem_type FROM `problem` WHERE type = ?";
        return getProblemFromDb(sql, type);
    }

}
