package service;


import dao.DeviceDAOImplement;
import dao.OrderDAOImplement;
import dao.ProblemDAOImplement;
import dao.UserDAOImplement;
import model.Device;
import model.Order;
import model.Status;
import org.json.JSONObject;

import java.sql.Date;
import java.util.Calendar;

public class InsertOrder {

    public void setOrderFromClient(String json) {
        JSONObject object = new JSONObject(json);
        String model = object.get("model").toString();
        String brand = object.get("brand").toString();
        String imei = object.get("imei").toString();
        int clientId = object.getInt("clientId");
        String comment = object.get("comment").toString();

        DeviceDAOImplement deviceDao = new DeviceDAOImplement();
        if (deviceDao.getDeviceByIMEI(imei) == null) {
            Device device = new Device();
            device.setBrand(brand);
            device.setModel(model);
            device.setImei(imei);
            device.setClient(clientId);
            deviceDao.add(device);
        }

        Order order = new Order();
        order.setComment(comment);
        order.setStatus(Status.CREATED);
        order.setDevice(deviceDao.getDeviceByIMEI(imei).getId());
        order.setClient(clientId);
        order.setStart_date(new Date(Calendar.getInstance().getTime().getTime()));

        OrderDAOImplement orderDao = new OrderDAOImplement();
        orderDao.add(order);

    }

    public void setOrderFromEmployee(String json) {

        JSONObject object = new JSONObject(json);
        String masterSurname = object.get("masterSurname").toString();
        String managerSurname = object.get("managerSurname").toString();
        String solving = object.get("solving").toString();
        Date endDate = Date.valueOf(object.get("endDate").toString());
        String status = object.get("status").toString();
        String clientLogin = object.get("clientLogin").toString();
        String model = object.get("model").toString();
        String brand = object.get("brand").toString();
        String imei = object.get("imei").toString();
        String comment = object.get("comment").toString();

        UserDAOImplement userDao = new UserDAOImplement();
        DeviceDAOImplement deviceDao = new DeviceDAOImplement();

        if (deviceDao.getDeviceByIMEI(imei) == null) {
            Device device = new Device();
            device.setBrand(brand);
            device.setModel(model);
            device.setImei(imei);
            device.setClient(userDao.getEntityByLogin(clientLogin).getId());
            deviceDao.add(device);
        }

        Order order = new Order();
        order.setComment(comment);
        order.setStatus(status);
        order.setDevice(deviceDao.getDeviceByIMEI(imei).getId());
        order.setClient(userDao.getEntityByLogin(clientLogin).getId());
        order.setStart_date(new Date(Calendar.getInstance().getTime().getTime()));
        order.setManager(userDao.getEntityBySurname(managerSurname).getId());
        order.setMaster(userDao.getEntityBySurname(masterSurname).getId());
        order.setProblem(new ProblemDAOImplement().getProblemBySolving(solving).getId());
        order.setEnd_date(endDate);


        OrderDAOImplement orderDao = new OrderDAOImplement();
        orderDao.add(order);
    }
}
