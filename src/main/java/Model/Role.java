package model;

public enum Role {
    ADMIN("admin"),
    MANAGER("manager"),
    MASTER("master"),
    CLIENT("client");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRoleToString() {
        return role;
    }
}
