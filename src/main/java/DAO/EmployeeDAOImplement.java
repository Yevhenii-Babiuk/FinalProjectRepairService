package dao;

import model.Employee;
import org.apache.log4j.Logger;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of DAO interface for Employee
 */
public class EmployeeDAOImplement  extends MySQLConnector implements DAOEmployees {
    private static final Logger LOG = Logger.getLogger(EmployeeDAOImplement.class);

    /**
     * Add entity into DB
     * @param entity get entity to insert it to DB
     */
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

    /**
     * Method for find all employees
     * @return List of employees
     */
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
                employeeList.add(employee);
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
        return employeeList;
    }

    /**
     * Get entity by parameter
     * @param id parameter for find entity
     * @return entity
     */
    @Override
    public Employee getEntityByKey(Integer id) {
        Connection connection = getConnection();
        String sql = "SELECT user_id, start_date FROM `employees` WHERE user_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee.setUserId(resultSet.getInt("user_id"));
            employee.setStartDate(resultSet.getDate("start_date"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            try {
                if(!resultSet.next()){
                    return null;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                LOG.debug("SQLException occurred");
            }
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

    /**
     * Update entity into DB
     * @param entity get entity to update new values into DB
     */
    @Override
    public void update(Employee entity) {
        Connection connection = getConnection();
        String sql = "UPDATE `employees` SET user_id=?, start_date=? WHERE user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setDate(2, entity.getStartDate());
            preparedStatement.setInt(3, entity.getUserId());
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

    /**
     * Delete entity in DB
     * @param entity what need to delete
     */
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

    /**
     * @param dateMin minimal Date for search
     * @param dateMax maximum Date for search
     * @return list of employees by start date in service
     */
    @Override
    public List<Employee> getEmployeeByStartDate(Date dateMin, Date dateMax) {
        String sql = "SELECT user_id, start_date FROM `employees` WHERE start_date BETWEEN ? AND ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, dateMin);
            preparedStatement.setDate(2, dateMax);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setUserId(resultSet.getInt("user_id"));
                employee.setStartDate(resultSet.getDate("start_date"));
            employeeList.add(employee);
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
        return employeeList;
    }

}