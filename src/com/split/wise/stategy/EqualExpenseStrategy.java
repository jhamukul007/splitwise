package com.split.wise.stategy;

import com.split.wise.dtos.ExpenseDto;
import com.split.wise.models.User;
import com.split.wise.service.UserService;

import java.util.List;

public class EqualExpenseStrategy implements ExpenseStrategy {
    private UserService userService;

    public EqualExpenseStrategy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void distribute(ExpenseDto expenseDto) {
        Double amountPerPerson = expenseDto.getAmount() / expenseDto.getNoOfUsers();
        User paidUser = userService.getByUserId(expenseDto.getPaidUserId());
        expenseDto.getUsers().forEach(userId -> {
            User user1 = userService.getByUserId(userId);
            if (user1 == null)
                return;
            if (expenseDto.getPaidUserId() == userId)
                return;
            // System.out.println(userId + "owe " + paidUser.getUserId() + " : " + amountPerPerson);
            paidUser.getUserExpense().oweAmount(userId, amountPerPerson);
            //  paidUser.getUserExpense().paidBorrowedAmount(userId, amountPerPerson);

            user1.getUserExpense().borrowAmount(paidUser.getUserId(), amountPerPerson);
//            user1.getUserExpense().receivedAmount(paidUser.getUserId(), amountPerPerson);
        });
    }
}
