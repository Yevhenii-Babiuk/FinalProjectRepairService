package dao;

import model.Feedback;
import org.apache.log4j.Logger;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOImplement extends MySQLConnector implements DAOFeedback {

    private static final Logger LOG = Logger.getLogger(FeedbackDAOImplement.class);
    @Override
    public void add(Feedback entity) {
        Connection connection = getConnection();
        String sql = "INSERT INTO `feedback` (id, rate, text) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getRate());
            preparedStatement.setString(3, entity.getText());
            preparedStatement.executeUpdate();
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Feedback> getAll() {
        Connection connection = getConnection();
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT id, rate, text FROM `feedback`";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(resultSet.getInt("id"));
                feedback.setRate(resultSet.getInt("rate"));
                feedback.setText(resultSet.getString("text"));
                feedbackList.add(feedback);
            }
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return feedbackList;
    }

    @Override
    public Feedback getEntityByKey(Integer id) {
        Connection connection = getConnection();
        String sql = "SELECT id, rate, text FROM `feedback` WHERE id = ?";
        PreparedStatement preparedStatement = null;
        Feedback feedback = new Feedback();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            feedback.setId(resultSet.getInt("id"));
            feedback.setRate(resultSet.getInt("rate"));
            feedback.setText(resultSet.getString("text"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return feedback;
    }

    @Override
    public void update(Feedback entity) {
        String sql = "UPDATE `feedback` SET id=?, rate=?, text=? WHERE id=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getRate());
            preparedStatement.setString(3, entity.getText());
            preparedStatement.executeUpdate();
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Feedback entity) {
        Connection connection = getConnection();
        String sql = "DELETE  FROM `feedback` WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Feedback> getFeedbackByRate(Integer rate) {
        String sql = "SELECT id, rate, text FROM `feedback` WHERE rate = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(resultSet.getInt("id"));
                feedback.setRate(resultSet.getInt("rate"));
                feedback.setText(resultSet.getString("text"));
                feedbackList.add(feedback);
            }
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return feedbackList;
    }

    @Override
    public Feedback getFeedbackByText(String text) {
        String sql = "SELECT id, rate, text FROM `feedback` WHERE text = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Feedback feedback = new Feedback();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, text);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                feedback.setId(resultSet.getInt("id"));
                feedback.setRate(resultSet.getInt("rate"));
                feedback.setText(resultSet.getString("text"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return feedback;
    }
}
