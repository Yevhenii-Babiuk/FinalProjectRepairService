package DAO;

import Model.Feedback;
import Util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOImplement extends MySQLConnector implements DAO<Feedback, Integer> {

    private Feedback setFeedbackFromDb(ResultSet resultSet) {
        Feedback feedback = new Feedback();
        try {
            feedback.setId(resultSet.getInt("id"));
            feedback.setRate(resultSet.getInt("rate"));
            feedback.setText(resultSet.getString("text"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedback;
    }

    private void setEmployeeToDb(PreparedStatement preparedStatement, Feedback entity) {
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getRate());
            preparedStatement.setString(3, entity.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Feedback getFeedbackFromDb(String sql, Integer parametr) {
        Feedback feedback = new Feedback();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, parametr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            feedback = setFeedbackFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return feedback;
    }

    @Override
    public void add(Feedback entity) {
        String sql = "INSERT INTO `feedback` (id, rate, text) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setEmployeeToDb(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }

    }

    @Override
    public List<Feedback> getAll(){
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT id, rate, text FROM `feedback`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Feedback feedback = setFeedbackFromDb(resultSet);
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return feedbackList;
    }

    @Override
    public Feedback getEntityByKey(Integer id) {
        String sql = "SELECT id, rate, text FROM `feedback` WHERE id = ?";
        return getFeedbackFromDb(sql, id);
    }

    @Override
    public void update(Feedback entity) {
        String sql = "UPDATE `feedback` SET id, rate, text WHERE id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setEmployeeToDb(preparedStatement, entity);
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Feedback entity) {
        String sql = "DELETE  FROM `feedback` WHERE id=?";
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

    public Feedback getFeedbackByExperience(Integer rate) {
        String sql = "SELECT id, rate, text FROM `feedback` WHERE rate = ?";
        return getFeedbackFromDb(sql, rate);
    }
}
