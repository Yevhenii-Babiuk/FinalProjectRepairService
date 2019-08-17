package dao;

import model.Problem;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAOImplement extends MySQLConnector implements DAOProblem {

    @Override
    public void add(Problem entity) {
        String sql = "INSERT INTO `problem` (id, problem, price) VALUES (?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getProblem());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public List<Problem> getAll() {
        List<Problem> problemList = new ArrayList<>();
        String sql = "SELECT id, problem, price FROM `problem`";
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Problem problem = new Problem();
                problem.setId(resultSet.getInt("id"));
                problem.setProblem(resultSet.getString("problem"));
                problem.setPrice(resultSet.getFloat("price"));
                problemList.add(problem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return problemList;
    }

    @Override
    public Problem getEntityByKey(Integer id) {
        String sql = "SELECT id, problem, price FROM `problem` WHERE id = ?";
        Connection connection = getConnection();
        Problem problem = new Problem();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            problem.setId(resultSet.getInt("id"));
            problem.setProblem(resultSet.getString("problem"));
            problem.setPrice(resultSet.getFloat("price"));
        } catch (SQLException e) {
            e.printStackTrace();
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
        return problem;
    }

    @Override
    public void update(Problem entity) {
        String sql = "UPDATE `problem` SET id=?, problem=?, price=? WHERE id=?";
        Connection connection =getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getProblem());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public void delete(Problem entity) {
        String sql = "DELETE  FROM `problem` WHERE id=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public List<Problem> getProblemByPrice(Float priceMin, Float priceMax) {
        String sql = "SELECT id, problem, price FROM `problem` WHERE price BETWEEN ? AND ?";
        Connection connection = getConnection();
        List<Problem> problemList = new ArrayList<>();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, priceMin);
            preparedStatement.setFloat(2, priceMax);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Problem problem = new Problem();
                problem.setId(resultSet.getInt("id"));
                problem.setProblem(resultSet.getString("problem"));
                problem.setPrice(resultSet.getFloat("price"));
                problemList.add(problem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return problemList;
    }

    @Override
    public Problem getProblemBySolving(String solving) {
        String sql = "SELECT id, problem, price FROM `problem` WHERE problem LIKE ?";
        Connection connection = getConnection();
        Problem problem = new Problem();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, solving);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                problem.setId(resultSet.getInt("id"));
                problem.setProblem(resultSet.getString("problem"));
                problem.setPrice(resultSet.getFloat("price"));

        } catch (SQLException e) {
            e.printStackTrace();
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
        return problem;
    }

}
