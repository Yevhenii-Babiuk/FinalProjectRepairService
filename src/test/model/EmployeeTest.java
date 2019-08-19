package model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee employee =null;

    @Before
    public void setUp() {
        employee = new Employee();
    }

    @Test
    public void TestGetAndSetUserId() {
        employee.setUserId(12345);
        assertEquals(12345, employee.getUserId());
    }

    @Test
    public void TestGetAndSetStartDate() {
        employee.setStartDate(Date.valueOf("2019-07-31"));
        assertEquals(Date.valueOf("2019-07-31"), employee.getStartDate());
    }

}