package dao;

import model.Employee;

import java.sql.Date;
import java.util.List;

/**
 * Base interface for DAO layer of Employees
 */
interface DAOEmployees extends DAO<Employee, Integer> {
    public List<Employee> getEmployeeByStartDate(Date dateMin, Date dateMax);
}
