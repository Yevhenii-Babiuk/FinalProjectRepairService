package dao;

import model.Device;
import model.Role;
import model.User;
import org.junit.*;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

public class DeviceDAOImplementTest {
    private DeviceDAOImplement deviceDao = new DeviceDAOImplement();
    private Device device = new Device();

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
    public void setDeviceBeforeEachTest(){
        device.setBrand("iPhone");
        device.setModel("X");
        device.setImei("184843456SF");
        device.setClient(3000);
        device.setId(2050);
        deviceDao.add(device);
    }

    @After
    public void deleteBeforeNextTest(){
        device.setId(2050);
        deviceDao.delete(device);
    }

    @Test
    public void getAll() {
        List<Device> devices=deviceDao.getAll();
        assertEquals(device, devices.get(devices.size()-1));

    }

    @Test
    public void add() {
        deviceDao.delete(device);
        device.setBrand("iPhone");
        device.setModel("XS MAX");
        device.setImei("184843456SF");
        device.setClient(3000);
        device.setId(2050);
        deviceDao.add(device);
        assertEquals(device, deviceDao.getEntityByKey(2050));
    }

    @Test
    public void update() {
        device.setModel("Xr");
        deviceDao.update(device);
        assertEquals(device, deviceDao.getEntityByKey(2050));
    }

    @Test
    public void delete() {
        deviceDao.delete(device);
        assertNull(deviceDao.getEntityByKey(2050));
    }

    @Test
    public void getEntityByKey() {
        assertEquals(device, deviceDao.getEntityByKey(2050));
    }

    @Test
    public void getDeviceByBrand() {
        List<Device> devices=deviceDao.getDeviceByBrand("iPhone");
        assertEquals(device, devices.get(devices.size()-1));
    }

    @Test
    public void getDeviceByModel() {
        List<Device> devices=deviceDao.getDeviceByModel("X");
        assertEquals(device, devices.get(devices.size()-1));
    }

    @Test
    public void getDeviceByIMEI() {
        assertEquals(device, deviceDao.getDeviceByIMEI("184843456SF"));
    }

    @Test
    public void getDeviceByClient() {
        List<Device> devices=deviceDao.getDeviceByClient(3000);
        assertEquals(device, devices.get(devices.size()-1));
    }
}