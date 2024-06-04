package org.buildozers;

import lombok.extern.slf4j.Slf4j;
import org.buildozers.streamapidojo.kata_03.Kata03;
import org.buildozers.streamapidojo.kata_03.Person;
import org.buildozers.streamapidojo.kata_03.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * /!\ DO NOT MODIFY THIS CLASS /!\ 
 */
@Slf4j
class Kata03Test {

    @Test
    @DisplayName("Given a list of transactions, when calculating the total transaction amount, then return the sum of all transaction values for each person.")
    void calculateTotalTransactionAmountTest() {

        // given
        List<Transaction> transactions = buildListOfTransactions();

        // when
        Map<Person, Long> result = Kata03.calculateTotalTransactionAmount(transactions);

        // logging
        result.forEach((person, totalAmount) -> log.info("Person: {}, Total Amount: {}", person, totalAmount));

        // then
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .containsEntry(Person.of("Wayne Bruce"), 3100L)
                .containsEntry(Person.of("Kent Clark"), 5200L)
                .containsEntry(Person.of("Dent Harvey"), 50L)
                .containsEntry(Person.of("Grayson Dick"), 100L)
                .containsEntry(Person.of("Wayne Damian"), 260L)
                .containsEntry(Person.of("West Wally"), 10L);
    }



    /**
     * /!\ DO NOT MODIFY THIS METHOD /!\ 
     * ---------------------------------
     * Build a list of transaction related to the person list
     *
     * @return list of transactions related to the given persons
     */
    private static List<Transaction> buildListOfTransactions() {

        Map <String, List<Long>> transactions = Map.of(
            "Wayne Bruce", List.of(100L, 1000L, 2000L),
            "Kent Clark", List.of(200L, 2000L, 3000L),
            "Dent Harvey", List.of(25L, 25L),
            "Grayson Dick", List.of(50L, 50L),
            "Wayne Damian", List.of(50L,60L,70L,80L),
            "West Wally", List.of(10L));

        // constructs a list of transactions for the given name converted into a Person
        return transactions.entrySet().stream()
            .flatMap(entry -> entry.getValue().stream()
                              .map(amount -> Transaction.builder().amount(amount)
                                                                  .person(Person.of(entry.getKey()))
                                                                  .build())
                    )
            .toList();
    }
}