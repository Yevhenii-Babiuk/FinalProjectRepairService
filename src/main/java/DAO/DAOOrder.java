package DAO;

import Model.Order;

import java.sql.Date;

interface DAOOrder extends DAO<Order, Integer>{
    public Order getOrderByClient(Integer client);
    public Order getOrderByManager(Integer manager);
    public Order getOrderByMaster(Integer master);
    public Order getOrderByDevice(Integer device);
    public Order getOrderByProblem(Integer problem);
    public Order getOrderByStartDate(Date min, Date max);
    public Order getOrderByEndDate(Date min, Date max);
    public Order getOrderByStatus(Boolean status);

}
