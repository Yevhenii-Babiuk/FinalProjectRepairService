package dto;

import dao.*;
import model.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class OrderDTOTest {
    private static Order order = null;
    private static OrderDTO orderDto = null;

    @BeforeClass
    public static void addAllEntityForDto(){
        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        ProblemDAOImplement problemDao = new ProblemDAOImplement();
        FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
        EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();
        OrderDAOImplement orderDao = new OrderDAOImplement();

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

        Device device = new Device();
        device.setBrand("iPhone");
        device.setModel("X");
        device.setImei("184843456SF");
        device.setClient(3000);
        device.setId(2050);
        deviceDao.add(device);

        Feedback feedback = new Feedback();
        feedback.setId(3018);
        feedback.setRate(5);
        feedback.setText("Great job!!!");
        feedbackDao.add(feedback);

        order = new Order();
        order.setId(3001);
        order.setStatus(Status.ACCEPTED);
        order.setFeedback(3018);
        order.setEnd_date(new Date(1567382400000L));
        order.setStart_date(new Date(1564790400000L));
        order.setMaster(3001);
        order.setManager(3002);
        order.setClient(3000);
        order.setComment("All are bad");
        order.setDevice(2050);
        order.setProblem(2999);
        orderDao.add(order);

        orderDto = new OrderDTO(order);
    }

    @AfterClass
    public static void deleteAllEntity(){
        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        ProblemDAOImplement problemDao = new ProblemDAOImplement();
        FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
        EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();
        OrderDAOImplement orderDao = new OrderDAOImplement();

        order.setId(3001);
        orderDao.delete(order);

        Employee employee = new Employee();
        employee.setUserId(3001);
        employeeDao.delete(employee);

        employee.setUserId(3002);
        employeeDao.delete(employee);

        Device device = new Device();
        device.setId(2050);
        deviceDao.delete(device);

        User user = new User();
        user.setId(3000);
        userDao.delete(user);

        user.setId(3001);
        userDao.delete(user);

        user.setId(3002);
        userDao.delete(user);

        Feedback feedback = new Feedback();
        feedback.setId(3018);
        feedbackDao.delete(feedback);

        Problem problem = new Problem();
        problem.setId(2999);
        problemDao.delete(problem);

    }

    @Test
    public void getOrder() {
        assertEquals(order, orderDto.getOrder());
    }

    @Test
    public void getClientName() {
        assertEquals("Test1", orderDto.getClientName());
    }

    @Test
    public void getClientSurname() {
        assertEquals("Test1", orderDto.getClientSurname());
    }

    @Test
    public void getClientLogin() {
        assertEquals("test_user@test.com", orderDto.getClientLogin());
    }

    @Test
    public void getMasterSurname() {
        assertEquals("Test2", orderDto.getMasterSurname());
    }

    @Test
    public void getManagerSurname() {
        assertEquals("Test3", orderDto.getManagerSurname());
    }

    @Test
    public void getDevice() {
        assertEquals("iPhone X", orderDto.getDevice());

    }

    @Test
    public void getProblem() {
        assertEquals("Install new OS", orderDto.getProblem());
    }

    @Test
    public void getPrice() {
        assertEquals(999F, orderDto.getPrice(), 0.1);
    }

    @Test
    public void getFeedback() {
        assertEquals("Great job!!!", orderDto.getFeedback());
    }
}