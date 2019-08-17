package service;

import dao.OrderDAOImplement;
import dao.ProblemDAOImplement;
import dao.UserDAOImplement;
import model.Order;
import org.json.JSONObject;

import java.sql.Date;

public class EditOrder {

    public void editOrder(String json) {
        JSONObject object = new JSONObject(json);
        int orderId = object.getInt("orderId");
        String masterSurname = object.get("masterSurname").toString();
        String managerSurname = object.get("managerSurname").toString();
        String solving = object.get("solving").toString();
        Date endDate = Date.valueOf(object.get("endDate").toString());
        String status = object.get("status").toString();

        OrderDAOImplement orderDao = new OrderDAOImplement();
        Order order = orderDao.getEntityByKey(orderId);

        order.setMaster(new UserDAOImplement().getEntityBySurname(masterSurname).getId());
        order.setManager(new UserDAOImplement().getEntityBySurname(managerSurname).getId());
        order.setProblem(new ProblemDAOImplement().getProblemBySolving(solving).getId());
        order.setEnd_date(endDate);
        order.setStatus(status);
        orderDao.update(order);
    }
}
