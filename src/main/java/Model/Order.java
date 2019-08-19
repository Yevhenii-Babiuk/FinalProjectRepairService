package model;

import java.sql.Date;
import java.util.Objects;

/**
 * Class realizing entity of order
 */
public class Order {
    private int id;
    private int client;
    private int manager;
    private int master;
    private int device;
    private int problem;
    private String comment;
    private Date start_date;
    private Status status;
    private Date end_date;
    private int feedback;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getMaster() {
        return master;
    }

    public void setMaster(int master) {
        this.master = master;
    }

    public int getProblem() {
        return problem;
    }

    public void setProblem(int problem) {
        this.problem = problem;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public void setStatus(String status) {
        for (Status st : Status.values()) {
            if (status.equals(st.getStatusToString())) {
                setStatus(st);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId() &&
                getClient() == order.getClient() &&
                getManager() == order.getManager() &&
                getMaster() == order.getMaster() &&
                getDevice() == order.getDevice() &&
                getProblem() == order.getProblem() &&
                getFeedback() == order.getFeedback() &&
                Objects.equals(getComment(), order.getComment()) &&
                Objects.equals(getStart_date(), order.getStart_date()) &&
                getStatus() == order.getStatus() &&
                Objects.equals(getEnd_date(), order.getEnd_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getManager(), getMaster(), getDevice(), getProblem(), getComment(), getStart_date(), getStatus(), getEnd_date(), getFeedback());
    }
}
