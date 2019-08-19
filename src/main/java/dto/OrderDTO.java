package dto;

import dao.*;
import model.*;


/**
 * Class that get entity of order and give of detail text information about order
 */
public class OrderDTO {
    private Order order;

    public OrderDTO(Order order) {
        this.order = order;
    }

    public Order getOrder() {
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
        if (user == null) {
            return null;
        } else {
            return user.getSurname();
        }
    }

    public String getManagerSurname() {
        UserDAOImplement userDAO = new UserDAOImplement();
        User user = userDAO.getEntityByKey(order.getManager());
        if (user == null) {
            return null;
        } else {
            return user.getSurname();
        }
    }

    public String getDevice() {
        DeviceDAOImplement deviceDAO = new DeviceDAOImplement();
        Device device = deviceDAO.getEntityByKey(order.getDevice());
        return device.getBrand() + " " + device.getModel();
    }

    public String getProblem() {
        ProblemDAOImplement problemDAO = new ProblemDAOImplement();
        Problem problem = problemDAO.getEntityByKey(order.getProblem());
        if (problem == null) {
            return null;
        } else {
            return problem.getProblem();
        }
    }


    public float getPrice() {
        ProblemDAOImplement problemDAO = new ProblemDAOImplement();
        Problem problem = problemDAO.getEntityByKey(order.getProblem());
        if (problem == null) {
            return Float.parseFloat(null);
        } else {
            return problem.getPrice();
        }
    }

    public String getFeedback() {
        FeedbackDAOImplement feedbackDAO = new FeedbackDAOImplement();
        Feedback feedback = feedbackDAO.getEntityByKey(order.getFeedback());
        if (feedback == null) {
            return null;
        } else {
            return feedback.getText();
        }
    }
}
