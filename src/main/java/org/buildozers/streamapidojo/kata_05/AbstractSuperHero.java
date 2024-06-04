package org.buildozers.streamapidojo.kata_05;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


/**
 * Abstract class representing a super hero whether it is alive or dead.
 * 
 */

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract class AbstractSuperHero {

    private final String pseudo;

    abstract boolean isAlive();
    abstract String fight();
    
}
