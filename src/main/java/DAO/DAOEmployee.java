package DAO;

import Model.Employee;

import java.sql.Date;

interface DAOEmployee extends DAO<Employee, Integer> {
    public Employee getEmployeeByStartDate(Date date);
    public Employee getEmployeeByExperience(Integer experience);
}
