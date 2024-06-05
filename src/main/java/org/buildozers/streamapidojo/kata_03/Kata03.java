package org.buildozers.streamapidojo.kata_03;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Kata03 {

    /**
     * Calculate the total amount of transactions for each person in the list of transactions.
     * Then return a map where the key is the person and the value is the total amount of transactions.
     * 
     * @param transactions list of transactions
     * @return map of person and total amount of transactions for that person
     */

    public static Map<Person, Long> calculateTotalTransactionAmount(List<Transaction> transactions) {
        return transactions.stream()
            .collect(Collectors.groupingBy(Transaction::getPerson, Collectors.summingLong(Transaction::getAmount)));
    }
    
}
