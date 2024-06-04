package org.buildozers.streamapidojo.kata_03;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString
@Builder
public class Transaction {

    private final long amount;
    private final Person person;

}
