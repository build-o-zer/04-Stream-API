package org.buildozers.streamapidojo.kata_05;

import java.util.Set;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@EqualsAndHashCode
public class Team {
    private final String pseudo;
    private final Set<AbstractSuperHero> superHeroes;
}
