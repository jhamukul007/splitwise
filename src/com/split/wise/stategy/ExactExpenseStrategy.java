package com.split.wise.stategy;

import com.split.wise.dtos.ExpenseDto;
import com.split.wise.models.User;
import com.split.wise.service.UserService;

import java.util.concurrent.atomic.AtomicInteger;

public class ExactExpenseStrategy implements ExpenseStrategy {
    private UserService userService;

    public ExactExpenseStrategy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void distribute(ExpenseDto expenseDto) {
        User paidUser = userService.getByUserId(expenseDto.getPaidUserId());
        AtomicInteger amountCount = new AtomicInteger(0);
        expenseDto.getUsers().forEach(borrowUserId -> {
            if (borrowUserId == paidUser.getUserId())
                return;
            User borrowedUser = userService.getByUserId(borrowUserId);
            Double borrowedAmount = expenseDto.getAmounts().get(amountCount.getAndIncrement());

            paidUser.getUserExpense().oweAmount(borrowUserId, borrowedAmount);
            borrowedUser.getUserExpense().borrowAmount(paidUser.getUserId(), borrowedAmount);
        });
    }
}
