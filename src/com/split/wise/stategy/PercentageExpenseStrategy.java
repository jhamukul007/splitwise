package com.split.wise.stategy;

import com.split.wise.dtos.ExpenseDto;
import com.split.wise.models.User;
import com.split.wise.service.UserService;

import java.util.concurrent.atomic.AtomicInteger;

public class PercentageExpenseStrategy implements ExpenseStrategy {

    private UserService userService;

    public PercentageExpenseStrategy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void distribute(ExpenseDto expenseDto) {

        User paidUser = userService.getByUserId(expenseDto.getPaidUserId());
        AtomicInteger amountCount = new AtomicInteger(0);
        expenseDto.getUsers().forEach(borrowedUserId -> {
            if (borrowedUserId == paidUser.getUserId())
                return;
            User borrowedUser = userService.getByUserId(borrowedUserId);
            Integer percentage = expenseDto.getPercentages().get(amountCount.getAndIncrement());
            Double amount = (expenseDto.getAmount() * percentage) / 100;
            // System.out.println("User- " + borrowedUserId + "owe " + " User- " + paidUser.getUserId() + " : " + amount);

            paidUser.getUserExpense().oweAmount(borrowedUserId, amount);
           // paidUser.getUserExpense().paidBorrowedAmount(borrowedUserId, amount);

            borrowedUser.getUserExpense().borrowAmount(paidUser.getUserId(), amount);
            // borrowedUser.getUserExpense().receivedAmount(paidUser.getUserId(), amount);
        });
    }
}
