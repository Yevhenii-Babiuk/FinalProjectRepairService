package dao;

import model.*;
import org.junit.*;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDAOImplementTest {
    private OrderDAOImplement orderDao = new OrderDAOImplement();
    private Order order = new Order();

    @BeforeClass
    public static void addAllEntityForOrder(){
        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        ProblemDAOImplement problemDao = new ProblemDAOImplement();
        FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
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
    }

    @AfterClass
    public static void deleteAllEntity(){
        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        ProblemDAOImplement problemDao = new ProblemDAOImplement();
        FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
        EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();

        User user = new User();
        user.setId(3000);
        userDao.delete(user);

        user.setId(3001);
        userDao.delete(user);

        user.setId(3002);
        userDao.delete(user);

        Device device = new Device();
        device.setId(2050);
        deviceDao.delete(device);

        Problem problem = new Problem();
        problem.setId(2999);
        problemDao.delete(problem);

        Feedback feedback = new Feedback();
        feedback.setId(3018);
        feedbackDao.delete(feedback);

        Employee employee = new Employee();
        employee.setUserId(3001);
        employeeDao.delete(employee);

        employee.setUserId(3002);
        employeeDao.delete(employee);
    }

    @Before
    public void addOrderBeforeTests(){
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
    }

    @After
    public void deleteOrderAfterTests(){
        order.setId(3001);
        orderDao.delete(order);
    }

    @Test
    public void getOrderByClient() {
        List<Order> orders = orderDao.getOrderByClient(3000);
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByMaster() {
        List<Order> orders = orderDao.getOrderByMaster(3001);
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByManager() {
        List<Order> orders = orderDao.getOrderByManager(3002);
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByDevice() {
        List<Order> orders = orderDao.getOrderByDevice(2050);
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByProblem() {
        List<Order> orders = orderDao.getOrderByProblem(2999);
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByStartDate() {
        List<Order> orders = orderDao.getOrderByStartDate(new Date(1564617600000L), new Date(1564963200000L));
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByEndDate() {
        List<Order> orders = orderDao.getOrderByEndDate(new Date(1567296000000L), new Date(1567641600000L));
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getOrderByStatus() {
        List<Order> orders = orderDao.getOrderByStatus(Status.ACCEPTED);
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void add() {
        orderDao.delete(order);
        order.setId(3001);
        order.setStatus(Status.ACCEPTED);
        order.setFeedback(3018);
        order.setEnd_date(new Date(1567296000000L));
        order.setStart_date(new Date(1564790400000L));
        order.setMaster(3001);
        order.setManager(3002);
        order.setClient(3000);
        order.setComment("I broken screen in my phone");
        order.setDevice(2050);
        order.setProblem(2999);
        orderDao.add(order);
        assertEquals(order, orderDao.getEntityByKey(3001));
    }

    @Test
    public void getAll() {
        List<Order> orders = orderDao.getAll();
        assertEquals(order, orders.get(orders.size()-1));
    }

    @Test
    public void getEntityByKey() {
        assertEquals(order, orderDao.getEntityByKey(3001));
    }

    @Test
    public void update() {
        order.setComment("Test my notepad");
        orderDao.update(order);
        assertEquals(order, orderDao.getEntityByKey(3001));
    }

    @Test
    public void delete() {
        orderDao.delete(order);
        assertNull(orderDao.getEntityByKey(3001));
    }
}