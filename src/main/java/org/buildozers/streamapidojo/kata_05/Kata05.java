package org.buildozers.streamapidojo.kata_05;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class Kata05 {

    /**
     * KATA: Refactor this method to use Java Stream API.
     * 
     * returns a map containing the number of available fighters per team.
     * 
     * @param team
     * @return
     */

    public static Map<Team, Integer> getNumberAvailableFighters(List<Team> team) {
        Map<Team, Integer> availableFightersPerTeam = new HashMap<>();
        for (Team t : team) {
            int count = 0;
            for (AbstractSuperHero s : t.getSuperHeroes()) {
                if (s.isAlive()) {
                    count++;
                }

                try {
                   log.info(s.fight());
                } catch (DeadException e) {
                   log.error("DeadException: " + e.getMessage());
                }
            }
            availableFightersPerTeam.put(t, count);
        }
        return availableFightersPerTeam;
    }

}
