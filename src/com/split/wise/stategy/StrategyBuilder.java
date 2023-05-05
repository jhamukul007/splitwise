package com.split.wise.stategy;

import com.split.wise.enuns.ExpenseStrategyEnums;
import com.split.wise.service.UserService;

public class StrategyBuilder {
    private final UserService userService;

    public StrategyBuilder(UserService userService) {
        this.userService = userService;
    }

    public ExpenseStrategy getStrategy(ExpenseStrategyEnums value){
        switch (value){
            case EXACT: return new ExactExpenseStrategy(userService);
            case EQUALS: return new EqualExpenseStrategy(userService);
            case PERCENT: return new PercentageExpenseStrategy(userService);
            default: throw new IllegalArgumentException("Invalid Expense Strategy");
        }
    }
}
