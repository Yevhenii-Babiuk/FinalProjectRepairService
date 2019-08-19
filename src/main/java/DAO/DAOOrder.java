package dao;

import model.*;

import java.sql.Date;
import java.util.List;

/**
 * Base interface for DAO layer of Order
 */

interface DAOOrder extends DAO<Order, Integer>{
    public List<Order> getOrderByClient(Integer client);
    public List<Order> getOrderByMaster(Integer master);
    public List<Order> getOrderByManager(Integer manager);
    public List<Order> getOrderByDevice(Integer device);
    public List<Order> getOrderByProblem(Integer problem);
    public List<Order> getOrderByStartDate(Date min, Date max);
    public List<Order> getOrderByEndDate(Date min, Date max);
    public List<Order> getOrderByStatus(Status status);

}
