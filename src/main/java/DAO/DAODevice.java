package dao;

import model.Device;

import java.util.List;

interface DAODevice extends DAO<Device, Integer> {
    public List<Device> getDeviceByBrand(String brand);
    public List<Device> getDeviceByModel(String model);
    public Device getDeviceByIMEI(String imei);
    public List<Device> getDeviceByClient(Integer client);
}
