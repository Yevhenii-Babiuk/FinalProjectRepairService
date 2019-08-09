package model;

import java.sql.Date;


public class Employee {
    private int userId;
    private Date startDate;
    private int experiense;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getExperiense() {
        return experiense;
    }

    public void setExperiense(int experiense) {
        this.experiense = experiense;
    }
}
