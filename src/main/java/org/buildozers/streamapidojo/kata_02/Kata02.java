package org.buildozers.streamapidojo.kata_02;

import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata02 {

    /**
     * KATA: Refactor this method to use Java Stream API.
     * 
     * @param transactions Array of transactions
     * @return sum of all transaction values
     */
    public static int getSumOfAllTransactionValues(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getValue() > 1000) 
            { 
                sum += transaction.getValue();
            }
        }
        return sum;
    }   
    
}
