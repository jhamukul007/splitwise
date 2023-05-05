package com.split.wise.dtos;

import java.util.List;

public class ExpenseDto {
    private Integer paidUserId;
    private Double amount;
    private Integer noOfUsers;
    private List<Integer> users;
    private List<Double> amounts;
    private List<Integer> percentages;

    private ExpenseDto(ExpenseDtoBuilder builder) {
        this.paidUserId = builder.paidUserId;
        this.amount = builder.amount;
        this.noOfUsers = builder.noOfUsers;
        this.users = builder.users;
        this.amounts = builder.amounts;
        this.percentages = builder.percentages;
    }

    public static ExpenseDtoBuilder builder(){
        return new ExpenseDto.ExpenseDtoBuilder();
    }

    public Integer getPaidUserId() {
        return paidUserId;
    }

    public void setPaidUserId(Integer paidUserId) {
        this.paidUserId = paidUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNoOfUsers() {
        return noOfUsers;
    }

    public void setNoOfUsers(Integer noOfUsers) {
        this.noOfUsers = noOfUsers;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public List<Double> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Double> amounts) {
        this.amounts = amounts;
    }

    public List<Integer> getPercentages() {
        return percentages;
    }

    public static class ExpenseDtoBuilder {
        private Integer paidUserId;
        private Double amount;
        private Integer noOfUsers;
        private List<Integer> users;
        private List<Double> amounts;
        private List<Integer> percentages;

        public ExpenseDtoBuilder setPaidUserId(Integer paidUserId) {
            this.paidUserId = paidUserId;
            return this;
        }

        public ExpenseDtoBuilder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseDtoBuilder setNoOfUsers(Integer noOfUsers) {
            this.noOfUsers = noOfUsers;
            return this;
        }

        public ExpenseDtoBuilder setUsers(List<Integer> users) {
            this.users = users;
            return this;
        }

        public ExpenseDtoBuilder setAmounts(List<Double> amounts) {
            this.amounts = amounts;
            return this;
        }

        public ExpenseDtoBuilder setPercentages(List<Integer> percentages) {
            this.percentages = percentages;
            return this;
        }

        public ExpenseDto build() {
            return new ExpenseDto(this);
        }
    }

}
