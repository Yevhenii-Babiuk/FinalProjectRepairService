package dto;

import dao.*;
import model.*;


public class OrderDTO {
    private Order order;

    public OrderDTO(Order order){this.order=order;}

    public Order getOrder(){
        return order;
    }

    public String getClientName() {
        UserDAOImplement userDAO = new UserDAOImplement();
        User user = userDAO.getEntityByKey(order.getClient());
        return user.getName();
    }

    public String getClientSurname() {
        UserDAOImplement userDAO = new UserDAOImplement();
        User user = userDAO.getEntityByKey(order.getClient());
        return user.getSurname();
    }

    public String getClientLogin() {
        UserDAOImplement userDAO = new UserDAOImplement();
        User user = userDAO.getEntityByKey(order.getClient());
        return user.getLogin();
    }

    public String getMasterSurname() {
        UserDAOImplement userDAO = new UserDAOImplement();
        User user = userDAO.getEntityByKey(order.getMaster());
        return user.getSurname();
    }

    public String getManagerSurname() {
        UserDAOImplement userDAO = new UserDAOImplement();
        User user = userDAO.getEntityByKey(order.getManager());
        return user.getSurname();
    }

    public String getDevice() {
        DeviceDAOImplement deviceDAO = new DeviceDAOImplement();
        Device device = deviceDAO.getEntityByKey(order.getDevice());
        return device.getBrand()+" "+device.getModel();
    }

    public String getProblem(){
        ProblemDAOImplement problemDAO = new ProblemDAOImplement();
        Problem problem = problemDAO.getEntityByKey(order.getProblem());
        return problem.getProblem();
    }

    public float getPrice(){
        ProblemDAOImplement problemDAO = new ProblemDAOImplement();
        Problem problem = problemDAO.getEntityByKey(order.getProblem());
        return problem.getPrice();
    }

    public String getFeedback(){
        FeedbackDAOImplement feedbackDAO = new FeedbackDAOImplement();
        Feedback feedback = feedbackDAO.getEntityByKey(order.getFeedback());
        return feedback.getText();
    }
}
