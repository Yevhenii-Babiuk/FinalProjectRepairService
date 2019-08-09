import dao.OrderDAOImplement;
import dto.OrderDTO;
import model.Order;

import java.util.ArrayList;
import java.util.List;


public class Domain {
    public static void main(String[] args) {
        OrderDAOImplement orderDAO = new OrderDAOImplement();
        List<Order> orders = orderDAO.getAll();
        List<OrderDTO> orderList = new ArrayList<>();
        for (int i =0; i<orders.size(); i++){
            Order order = orders.get(i);
            orderList.add(new OrderDTO(order));
            System.out.println(order);
        }
    }
}
