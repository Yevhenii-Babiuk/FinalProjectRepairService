package dao;

import model.Feedback;

import java.util.List;

public interface DAOFeedback extends DAO <Feedback, Integer> {
    public List<Feedback> getFeedbackByRate(Integer rate);
}
