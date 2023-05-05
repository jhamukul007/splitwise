package com.split.wise.service;

import com.split.wise.dtos.ExpenseDto;
import com.split.wise.enuns.ExpenseStrategyEnums;
import com.split.wise.exceptions.ResourceAlreadyExistException;
import com.split.wise.models.User;
import com.split.wise.stategy.StrategyBuilder;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Integer, User> usersMap;
    private StrategyBuilder strategyBuilder;

    public UserService() {
        this.usersMap = new HashMap<>();
        this.strategyBuilder = new StrategyBuilder(this);
    }

    public void registerUser(User user) {
        User existingUser = usersMap.get(user.getUserId());
        if (existingUser != null)
            throw new ResourceAlreadyExistException("User already exist");
        usersMap.put(user.getUserId(), user);
    }

    public User getByUserId(Integer userId) {
        return usersMap.get(userId);
    }

    public void showAmount(Integer userId) {
        User user = getByUserId(userId);
        user.getUserExpense().getOweUserAmount().forEach((borrowedUserId, amount) -> {
            System.out.println("User- " + borrowedUserId + " owes " + " User- " + userId + " : " + amount);
        });
    }

    public void addExpense(ExpenseStrategyEnums expenseStrategyEnums, ExpenseDto expenseDto) {
        strategyBuilder.getStrategy(expenseStrategyEnums).distribute(expenseDto);
    }
}
