package dao;

import model.Device;

interface DAODevice extends DAO<Device, Integer> {
    public Device getDeviceByBrand(String brand);
    public Device getDeviceByModel(String model);
    public Device getDeviceByIMEI(String imei);
    public Device getDeviceByClient(Integer client);
}
