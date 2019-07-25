package DAO;

import Model.ProblemType;
import Util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemTypeDAOImplement extends MySQLConnector implements DAO <ProblemType, Integer> {

    private ProblemType setProblemTypeFromDb(ResultSet resultSet) {
        ProblemType problemType = new ProblemType();
        try {
            problemType.setId(resultSet.getInt("id"));
            problemType.setType(resultSet.getString("type"));
            problemType.setPrice(resultSet.getFloat("price"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return problemType;
    }

    private void setProblemTypeToDb(PreparedStatement preparedStatement, ProblemType entity) {
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getType());
            preparedStatement.setFloat(3, entity.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(ProblemType entity) {
        String sql = "INSERT INTO `problem_type` (id, type, price) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setProblemTypeToDb(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public List<ProblemType> getAll(){
        List<ProblemType> problemTypeList = new ArrayList<>();
        String sql = "SELECT id, type, price FROM `problem_type`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ProblemType problemType = setProblemTypeFromDb(resultSet);
                problemTypeList.add(problemType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return problemTypeList;
    }

    @Override
    public ProblemType getEntityByKey(Integer id) {
        String sql = "SELECT id, type, price FROM `problem_type` WHERE id = ?";
        ProblemType problemType = new ProblemType();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            problemType = setProblemTypeFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return problemType;
    }

    @Override
    public void update(ProblemType entity) {
        String sql = "UPDATE `problem_type` SET id=?, type=?, price=? WHERE id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setProblemTypeToDb(preparedStatement, entity);
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(ProblemType entity) {
        String sql = "DELETE  FROM `problem_type` WHERE id=?";
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

    public ProblemType getFeedbackByExperience(String type) {
        String sql = "SELECT id, type, price FROM `problem_type` WHERE type LIKE ?";
        ProblemType problemType = new ProblemType();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            problemType = setProblemTypeFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return problemType;
    }
}
