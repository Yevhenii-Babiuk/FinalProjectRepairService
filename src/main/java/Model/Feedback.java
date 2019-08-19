package model;

import java.util.Objects;

/**
 * Class realizing entity of feedback
 */
public class Feedback {
    private int id;
    private int rate;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return getId() == feedback.getId() &&
                getRate() == feedback.getRate() &&
                getText().equals(feedback.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRate(), getText());
    }
}
