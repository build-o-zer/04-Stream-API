package org.buildozers;

import org.buildozers.streamapidojo.kata_05.AliveSuperHero;
import org.buildozers.streamapidojo.kata_05.DeadSuperHero;
import org.buildozers.streamapidojo.kata_05.Kata05;
import org.buildozers.streamapidojo.kata_05.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * /!\ DO NOT MODIFY THIS CLASS /!\ 
 */
class Kata05Test {

    @Test
    @DisplayName("Given a list of superhero, when getting the number of available fighters, then return the number of fighters available.")
    void getNumberAvailableFighter() {

        // given
        Team justiceLeague =Team.builder().pseudo("Justice League")
            .superHeroes(Set.of(new AliveSuperHero("Batman"), 
                                new AliveSuperHero("Superman"), 
                                new DeadSuperHero("Wonder Woman"),
                                new DeadSuperHero("Flash"),
                                new AliveSuperHero("Green Lantern"),
                                new DeadSuperHero("Aquaman"),
                                new AliveSuperHero("Robin")))
            .build();

        Team avengers = Team.builder().pseudo("Avengers")
            .superHeroes(Set.of(new AliveSuperHero("Spiderman"), 
                                new AliveSuperHero("Iron Man"),
                                new DeadSuperHero("Captain America"),
                                new DeadSuperHero("Black Widow"),
                                new AliveSuperHero("Hulk"),
                                new DeadSuperHero("Thor")))
            .build();

        List<Team> teams = List.of(justiceLeague, avengers);    

        // when
        Map <Team, Integer> result = Kata05.getNumberAvailableFighters(teams);

        // Then
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .containsEntry(justiceLeague, 4)
                .containsEntry(avengers, 3);
    }
}