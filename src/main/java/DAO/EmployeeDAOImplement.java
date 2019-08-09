package dao;

import model.Employee;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplement  extends MySQLConnector implements DAOEmployees {

    @Override
    public void add(Employee entity) {
        Connection connection = getConnection();
        String sql = "INSERT INTO `employees` (user_id, start_date) VALUES (?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setDate(2, entity.getStartDate());
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
    public List<Employee> getAll() {
        Connection connection = getConnection();
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT user_id, start_date FROM `employees`";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setUserId(resultSet.getInt("user_id"));
                employee.setStartDate(resultSet.getDate("start_date"));
                employee.setExperiense(resultSet.getInt("experience"));
                employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public Employee getEntityByKey(Integer id) {
        Connection connection = getConnection();
        String sql = "SELECT user_id, start_date FROM `employees` WHERE user_id = ?";
        PreparedStatement preparedStatement = null;
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee.setUserId(resultSet.getInt("user_id"));
            employee.setStartDate(resultSet.getDate("start_date"));

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
        return employee;
    }


    @Override
    public void update(Employee entity) {
        Connection connection = getConnection();
        String sql = "UPDATE `employees` SET user_id=?, start_date=? WHERE user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setDate(2, entity.getStartDate());
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
    public void delete(Employee entity) {
        Connection connection = getConnection();
        String sql = "DELETE FROM `employees` WHERE user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getUserId());
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
    public Employee getEmployeeByStartDate(Date dateMin, Date dateMax) {
        String sql = "SELECT user_id, start_date FROM `employees` WHERE start_date BETWEEN ? AND ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, dateMin);
            preparedStatement.setDate(2, dateMax);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee.setUserId(resultSet.getInt("user_id"));
            employee.setStartDate(resultSet.getDate("start_date"));

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
        return employee;
    }

}