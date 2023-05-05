package com.split.wise.models;

public class User {
    private Integer userId;
    private String name;
    private String email;
    private Long phone;
    private UserExpense userExpense;

    public User() {
        this.userExpense = new UserExpense();
    }

    public User(Integer userId, String name, String email, Long phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userExpense = new UserExpense();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public UserExpense getUserExpense() {
        return userExpense;
    }

}
