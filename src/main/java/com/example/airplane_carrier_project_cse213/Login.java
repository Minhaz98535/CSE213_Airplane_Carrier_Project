package com.example.airplane_carrier_project_cse213;

public class Login {
    private String userRole;
    private Integer userId;
    private String password;

    public Login(String userRole, Integer userId, String password) {
        this.userRole = userRole;
        this.userId = userId;
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userRole='" + userRole + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
