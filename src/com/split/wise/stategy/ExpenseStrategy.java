package com.split.wise.stategy;

import com.split.wise.dtos.ExpenseDto;

public interface ExpenseStrategy {
    void distribute(ExpenseDto expenseDto);
}
