package dao;

import model.Employee;

import java.sql.Date;
import java.util.List;

interface DAOEmployees extends DAO<Employee, Integer> {
    public List<Employee> getEmployeeByStartDate(Date dateMin, Date dateMax);
}
