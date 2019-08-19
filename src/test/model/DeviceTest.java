package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceTest {
    private Device device =null;
    @Before
    public void setUp() {
        device = new Device();
    }

    @Test
    public void getAndSetIdTest() {
        device.setId(1123);
        assertEquals(1123, device.getId());
    }

    @Test
    public void getAndSetClientTest() {
        device.setClient(148);
        assertEquals(148, device.getClient());
    }

    @Test
    public void getAndSetBrandTest() {
        device.setBrand("Xiaomi");
        assertEquals("Xiaomi", device.getBrand());
    }


    @Test
    public void getAndSetModelTest() {
        device.setModel("6S+");
        assertEquals("6S+", device.getModel());
    }


    @Test
    public void getAndSetImeiTest() {
        device.setImei("445115F1548");
        assertEquals("445115F1548", device.getImei());
    }
}