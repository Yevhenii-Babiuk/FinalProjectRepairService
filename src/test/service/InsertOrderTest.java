package service;

import dao.*;
import model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class InsertOrderTest {
    private static OrderDAOImplement orderDao = new OrderDAOImplement();
    private InsertOrder insertOrder = new InsertOrder();

    @BeforeClass
    public static void addAllEntityForOrder(){
        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        ProblemDAOImplement problemDao = new ProblemDAOImplement();
        EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();

        User user = new User();
        user.setId(3000);
        user.setRole(Role.CLIENT);
        user.setLogin("test_user@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380000000001");
        user.setSurname("Test1");
        user.setName("Test1");
        user.setPassword("00000000");
        userDao.add(user);

        user.setId(3001);
        user.setRole(Role.MASTER);
        user.setLogin("test_user_master@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380000000002");
        user.setSurname("Test2");
        user.setName("Test2");
        user.setPassword("00000000");
        userDao.add(user);

        user.setId(3002);
        user.setRole(Role.MANAGER);
        user.setLogin("test_user_manager@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380000000003");
        user.setSurname("Test3");
        user.setName("Test3");
        user.setPassword("00000000");
        userDao.add(user);

        Employee employee = new Employee();
        employee.setUserId(3001);
        employee.setStartDate(new Date(1528146000000L));
        employeeDao.add(employee);

        employee.setUserId(3002);
        employee.setStartDate(new Date(1528146000000L));
        employeeDao.add(employee);

        Problem problem = new Problem();
        problem.setId(2999);
        problem.setPrice(999);
        problem.setProblem("Install new OS");
        problemDao.add(problem);

    }

    @AfterClass
    public static void deleteAllEntity(){
        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        ProblemDAOImplement problemDao = new ProblemDAOImplement();
        FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
        EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();

        List<Order> orders = orderDao.getOrderByClient(3000);
        for (Order order : orders) {
            orderDao.delete(order);
        }

        Employee employee = new Employee();
        employee.setUserId(3001);
        employeeDao.delete(employee);

        employee.setUserId(3002);
        employeeDao.delete(employee);

        List<Device> devices= deviceDao.getDeviceByClient(3000);
        for (Device device : devices) {
            deviceDao.delete(device);
        }

        User user = new User();
        user.setId(3000);
        userDao.delete(user);

        user.setId(3001);
        userDao.delete(user);

        user.setId(3002);
        userDao.delete(user);

        Problem problem = new Problem();
        problem.setId(2999);
        problemDao.delete(problem);

        Feedback feedback = new Feedback();
        feedback.setId(3018);
        feedbackDao.delete(feedback);
    }

    @Test
    public void setOrderFromClient() {
        String json="{\"brand\":\"Xiaomi\",\"model\":\"M9\",\"imei\":\"FGHJ784874D\",\"comment\":\"SOS\",\"clientId\":\"3000\"}";
        insertOrder.setOrderFromClient(json);
        assertEquals("FGHJ784874D", new DeviceDAOImplement().getDeviceByIMEI("FGHJ784874D").getImei());

    }

    @Test
    public void setOrderFromEmployee() {
        String json = "{\"brand\":\"Xiaomi\",\"model\":\"M6 Note\",\"imei\":\"7845RTYUI8456\",\"comment\":\"Help me\",\"solving\":\"Cleaning fingerprint\",\"clientLogin\":\"test_user@test.com\",\"status\":\"created\",\"masterSurname\":\"Test2\",\"managerSurname\":\"Test3\",\"endDate\":1567728000000}";
        insertOrder.setOrderFromEmployee(json);
        assertEquals("7845RTYUI8456", new DeviceDAOImplement().getDeviceByIMEI("7845RTYUI8456").getImei());
    }
}