package service;

import dao.OrderDAOImplement;
import dto.OrderDTO;
import model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns all order with text details
 */
public class GetOrderWithDetails {

    public List<OrderDTO> getOrder() {
        OrderDAOImplement orderDAO = new OrderDAOImplement();
        List<Order> orders = orderDAO.getAll();
        List<OrderDTO> orderList = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            orderList.add(new OrderDTO(order));
        }
        return orderList;
    }
}