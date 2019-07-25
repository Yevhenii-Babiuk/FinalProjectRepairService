package DAO;

import Model.Employee;
import Util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplement  extends MySQLConnector implements DAOEmployee {

    private Employee setEmployeeFromDb(ResultSet resultSet) {
        Employee employee = new Employee();
        try {
            employee.setUserId(resultSet.getInt("user_id"));
            employee.setStartDate(resultSet.getDate("start_date"));
            employee.setExperiense(resultSet.getInt("experience"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    private void setEmployeeToDb(PreparedStatement preparedStatement, Employee entity) {
        try {
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setDate(2, entity.getStartDate());
            preparedStatement.setInt(3, entity.getExperiense());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Employee getEmployeesFromDb(String sql, Integer parametr) {
        Employee employee = new Employee();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, parametr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee = setEmployeeFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return employee;
    }

    @Override
    public void add(Employee entity) {
        String sql = "INSERT INTO `emploees` (user_id, start_date, experience) VALUES (?, ?, ?)";

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
    public List<Employee> getAll(){
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT user_id, start_date, experience FROM `employees`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = setEmployeeFromDb(resultSet);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return employeeList;
    }

    @Override
    public Employee getEntityByKey(Integer id) {
        String sql = "SELECT user_id, start_date, experience FROM `employees` WHERE user_id = ?";
        return getEmployeesFromDb(sql, id);
    }

    @Override
    public void update(Employee entity) {
        String sql = "UPDATE `employees` SET user_id=?, start_date=?, experience=? WHERE user_id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setEmployeeToDb(preparedStatement, entity);
            preparedStatement.setInt(4, entity.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Employee entity) {
        String sql = "DELETE FROM `employees` WHERE user_id=?";
        PreparedStatement preparedStatement =getPrepareStatement(sql);

        try {
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public Employee getEmployeeByStartDate(Date date) {
        String sql = "SELECT user_id, start_date, experience FROM `employees` WHERE start_date = ?";
        Employee employee = new Employee();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee = setEmployeeFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByExperience(Integer experience) {
        String sql = "SELECT user_id, start_date, experience FROM `employees` WHERE experience = ?";
        return getEmployeesFromDb(sql, experience);
    }
}
