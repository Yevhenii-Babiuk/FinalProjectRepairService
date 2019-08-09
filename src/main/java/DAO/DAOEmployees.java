package dao;

import model.Employee;

import java.sql.Date;

interface DAOEmployees extends DAO<Employee, Integer> {
    public Employee getEmployeeByStartDate(Date dateMin, Date dateMax);
}
