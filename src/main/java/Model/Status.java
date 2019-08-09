package model;

public enum Status {
    CREATED("created"),
    ACCEPTED("accepted"),
    DONE("done");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatusToString() {
        return status;
    }
}
