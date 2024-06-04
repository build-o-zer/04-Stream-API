package org.buildozers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.buildozers.streamapidojo.kata_02.Kata02;
import org.buildozers.streamapidojo.kata_02.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * /!\ DO NOT MODIFY THIS CLASS /!\ 
 */
@Slf4j
class Kata02Test {

    @Test
    @DisplayName("Given a list of transactions, when calculating the sum of all transaction values only above 1000, then return the sum of all transaction values.")
    void getSumOfAllTransactionValuesTest() {
        // given
        List<Transaction> transactions = List.of(new Transaction(500),
            new Transaction(1500),
            new Transaction(3000),
            new Transaction(700));

        // when
        int sum = Kata02.getSumOfAllTransactionValues(transactions);

        // log
        log.info("Sum of all transaction values: {}", sum);

        // then
        assertThat(sum).isEqualTo(4500);
    }
}