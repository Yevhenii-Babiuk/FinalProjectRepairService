package model;

import java.sql.Date;
import java.util.Objects;

/**
 * Class realizing entity of employee
 */
public class Employee {
    private int userId;
    private Date startDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getUserId() == employee.getUserId() &&
                getStartDate().equals(employee.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getStartDate());
    }
}
