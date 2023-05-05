package com.split.wise.models;

import java.util.HashMap;
import java.util.Map;

public class UserExpense {

    private Map<Integer, Double> oweUserAmount;
    private Map<Integer, Double> borrowedUserAmount;

    public UserExpense() {
        this.oweUserAmount = new HashMap<>();
        this.borrowedUserAmount = new HashMap<>();
    }

    public void oweAmount(Integer userId, Double amount) {
        Double borrowedAmount = borrowedUserAmount.getOrDefault(userId, 0D);
        Double oweAmount = oweUserAmount.getOrDefault(userId, 0D);
        if (amount + oweAmount > borrowedAmount) {
            oweUserAmount.put(userId, (amount + oweAmount) - borrowedAmount);
            borrowedUserAmount.remove(userId);
        } else {
            borrowedUserAmount.put(userId, borrowedAmount - (amount + oweAmount));
            oweUserAmount.remove(userId);
        }
    }

    public void borrowAmount(Integer userId, Double amount) {
        Double oweAmount = oweUserAmount.getOrDefault(userId, 0D);
        Double borrowAmount = borrowedUserAmount.getOrDefault(userId, 0D);
        if (amount + borrowAmount > oweAmount) {
            borrowedUserAmount.put(userId, (amount + borrowAmount) - oweAmount);
            oweUserAmount.remove(userId);
        } else {
            oweUserAmount.put(userId, oweAmount - (amount + borrowAmount));
            borrowedUserAmount.remove(userId);
        }
    }

    public Map<Integer, Double> getOweUserAmount() {
        return oweUserAmount;
    }

}
