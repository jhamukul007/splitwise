package com.split.wise;

import com.split.wise.dtos.ExpenseDto;
import com.split.wise.enuns.ExpenseStrategyEnums;
import com.split.wise.models.User;
import com.split.wise.service.UserService;

import java.util.Arrays;

public class MainRunner {

    public static void main(String[] args) {

        UserService userService = new UserService();

        User user1 = new User(1, "Mukul", "mukul@gmail.com", 8769133427L);
        User user2 = new User(2, "Rajat", "rajat@gmail.com", 87691339090L);
        User user3 = new User(3, "Viral", "viral@gmail.com", 9999999999L);
        User user4 = new User(4, "Lokesh", "lokesh@gmail.com", 77777777777L);

        userService.registerUser(user1);
        userService.registerUser(user2);
        userService.registerUser(user3);
        userService.registerUser(user4);

        System.out.println("User registered  successfully");

        ExpenseDto expenseDto1 = ExpenseDto.builder()
                .setPaidUserId(user1.getUserId())
                .setAmount(1000D)
                .setNoOfUsers(4)
                .setUsers(Arrays.asList(user1.getUserId(), user2.getUserId(), user3.getUserId(), user4.getUserId()))
                .build();
        userService.addExpense(ExpenseStrategyEnums.EQUALS, expenseDto1);
        //System.out.println("-----------------------------------");
        //userService.showAmount(user1.getUserId());

        ExpenseDto expenseDto2 = ExpenseDto.builder()
                .setPaidUserId(user1.getUserId())
                .setAmount(1250D)
                .setNoOfUsers(2)
                .setUsers(Arrays.asList(user2.getUserId(), user3.getUserId()))
                .setAmounts(Arrays.asList(370D, 880D))
                .build();
        userService.addExpense(ExpenseStrategyEnums.EXACT, expenseDto2);
       // System.out.println("-----------------------------------");
        userService.showAmount(user1.getUserId());

         ExpenseDto expenseDto3 = ExpenseDto.builder()
                .setPaidUserId(user4.getUserId())
                .setAmount(1200D)
                .setNoOfUsers(4)
                .setUsers(Arrays.asList(user1.getUserId(), user2.getUserId(), user3.getUserId(), user4.getUserId()))
                .setPercentages(Arrays.asList(40, 20, 20, 20))
                .build();
        userService.addExpense(ExpenseStrategyEnums.PERCENT, expenseDto3);
        System.out.println("-----------------------------------");
        userService.showAmount(user1.getUserId());
        System.out.println("-----------------------------------");
        userService.showAmount(user4.getUserId());

    }
}
