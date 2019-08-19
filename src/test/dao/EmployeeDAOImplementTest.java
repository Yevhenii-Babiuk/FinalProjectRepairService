package dao;

import model.Employee;
import model.Role;
import model.User;
import org.junit.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDAOImplementTest {
    private EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();
    private Employee employee = new Employee();

    @BeforeClass
    public static void addClientBeforeTests(){
        UserDAOImplement userDao = new UserDAOImplement();
        User user = new User();
        user.setId(3000);
        user.setRole(Role.CLIENT);
        user.setLogin("test_user@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380000000000");
        user.setSurname("Test");
        user.setName("Test");
        user.setPassword("00000000");
        userDao.add(user);
    }

    @AfterClass
    public static void deleteClientBeforeTests(){
        UserDAOImplement userDao = new UserDAOImplement();
        User user = new User();
        user.setId(3000);
        userDao.delete(user);
    }

    @Before
    public void setEmployeeBeforeEachTest(){
        employee.setUserId(3000);
        employee.setStartDate( new Date(1566172800000L));
        employeeDao.add(employee);
    }

    @After
    public void deleteBeforeNextTest(){
        employee.setUserId(3000);
        employeeDao.delete(employee);
    }

    @Test
    public void add() {
        employeeDao.delete(employee);
        employee.setUserId(3000);
        employee.setStartDate( new Date(1566259200000L));
        employeeDao.add(employee);
        Employee compareEmployee = employeeDao.getEntityByKey(3000);
        assertEquals(employee, compareEmployee);
    }

    @Test
    public void getAll() {
        List<Employee> employees = employeeDao.getAll();
        assertEquals(employee, employees.get(employees.size()-1));
    }

    @Test
    public void getEntityByKey() {
        assertEquals(employee, employeeDao.getEntityByKey(3000));
    }

    @Test
    public void update() {
        employee.setStartDate( new Date(1566259200000L));
        employeeDao.update(employee);
        Employee compareEmployee = employeeDao.getEntityByKey(3000);
        assertEquals(employee, compareEmployee);
    }

    @Test
    public void delete() {

        employeeDao.delete(employee);
        Employee compareEmployee = employeeDao.getEntityByKey(3000);
        assertNull(compareEmployee);
    }

    @Test
    public void getEmployeeByStartDate() {
        List<Employee> employees = employeeDao.getEmployeeByStartDate(Date.valueOf("2019-08-15"), Date.valueOf("2019-09-01"));
        assertEquals(employee, employees.get(employees.size()-1));
    }
}