package service;

import dao.FeedbackDAOImplement;
import dao.OrderDAOImplement;
import model.Feedback;
import model.Order;
import org.json.JSONObject;

public class AddFeedback {
    public void add(String json){
        JSONObject object = new JSONObject(json);
        String text = object.getString("text");
        int rate = object.getInt("rate");
        int orderId = object.getInt("orderId");

        FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
        OrderDAOImplement orderDao = new OrderDAOImplement();
        Feedback feedback = new Feedback();
        feedback.setRate(rate);
        feedback.setText(text);
        feedbackDao.add(feedback);
        int feedbackId = feedbackDao.getFeedbackByText(text).getId();
        Order order = orderDao.getEntityByKey(orderId);
        order.setFeedback(feedbackId);
        orderDao.update(order);

    }
}
