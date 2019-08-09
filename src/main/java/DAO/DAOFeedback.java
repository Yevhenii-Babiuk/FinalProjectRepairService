package dao;

import model.Feedback;

public interface DAOFeedback extends DAO <Feedback, Integer> {
    public Feedback getFeedbackByRate(Integer rate);
}
