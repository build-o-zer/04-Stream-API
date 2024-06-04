package org.buildozers.streamapidojo.kata_03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata03 {

    /**
     * KATA: Refactor this method to use Java Stream API.
     * 
     * Calculate the total amount of transactions for each person in the list of transactions.
     * Then return a map where the key is the person and the value is the total amount of transactions.
     * 
     * @param transactions list of transactions
     * @return map of person and total amount of transactions for that person
     */

    public static Map<Person, Long> calculateTotalTransactionAmount(List<Transaction> transactions) {
        Map<Person, Long> totalAmounts = new HashMap<>();

        for (Transaction transaction : transactions) {
            Person person = transaction.getPerson();
            long amount = transaction.getAmount();
            totalAmounts.put(person, totalAmounts.getOrDefault(person, 0L) + amount);
        }

        return totalAmounts;
    }
    
}
