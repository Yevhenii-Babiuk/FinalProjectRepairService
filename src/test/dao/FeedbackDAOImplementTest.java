package dao;

import model.Feedback;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FeedbackDAOImplementTest {
    private FeedbackDAOImplement feedbackDao = new FeedbackDAOImplement();
    private Feedback feedback = new Feedback();

    @Before
    public void setFeedbackBeforeEachTest() {
        feedback.setId(3018);
        feedback.setRate(5);
        feedback.setText("Great job!");
        feedbackDao.add(feedback);
    }

    @After
    public void deleteBeforeNextTest() {
        feedback.setId(3018);
        feedbackDao.delete(feedback);
    }

    @Test
    public void add() {
        feedbackDao.delete(feedback);
        feedback.setId(3018);
        feedback.setRate(3);
        feedback.setText("Great job!");
        feedbackDao.add(feedback);
        assertEquals(feedback, feedbackDao.getEntityByKey(3018));
    }

    @Test
    public void getAll() {
        List<Feedback> feedbacks = feedbackDao.getAll();
        assertEquals(feedback, feedbacks.get(feedbacks.size()-1));
    }

    @Test
    public void getEntityByKey() {
        assertEquals(feedback, feedbackDao.getEntityByKey(3018));
    }

    @Test
    public void update() {
        feedback.setText("You are great");
        feedbackDao.update(feedback);
        assertEquals(feedback, feedbackDao.getEntityByKey(3018));
    }

    @Test
    public void delete() {
        feedbackDao.delete(feedback);
        assertNull(feedbackDao.getEntityByKey(3018));
    }

    @Test
    public void getFeedbackByRate() {
        List<Feedback> feedbacks = feedbackDao.getFeedbackByRate(5);
        assertEquals(feedback, feedbacks.get(feedbacks.size()-1));
    }

    @Test
    public void getFeedbackByText() {
        assertEquals(feedback, feedbackDao.getFeedbackByText("Great job!!!"));
    }
}