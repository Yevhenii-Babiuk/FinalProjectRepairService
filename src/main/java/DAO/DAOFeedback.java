package dao;

import model.Feedback;

import java.util.List;

/**
 * Base interface for DAO layer of Feedback
 */

public interface DAOFeedback extends DAO <Feedback, Integer> {
    public List<Feedback> getFeedbackByRate(Integer rate);
    public Feedback getFeedbackByText(String text);
}
