package org.buildozers.streamapidojo.kata_02;

import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata02 {

    /**
     * returns the sum of all transaction values, but only for transactions with a value greater than 1000.
     * 
     * @param transactions Array of transactions
     * @return sum of all transaction values
     */
    public static int getSumOfAllTransactionValues(List<Transaction> transactions) {
        return transactions.stream()
            .mapToInt(Transaction::getValue)
            .filter(value -> value > 1000)            
            .sum();
    }   
    
}
