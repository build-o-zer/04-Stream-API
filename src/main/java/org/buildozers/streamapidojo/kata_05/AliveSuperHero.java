package org.buildozers.streamapidojo.kata_05;

import lombok.Builder;

/**
 * A super hero that is alive and can fight.
 */
public class AliveSuperHero extends AbstractSuperHero {

    @Builder
    public AliveSuperHero(String pseudo) {
        super(pseudo);
    }

    @Override
    boolean isAlive() {
        return true;
    }

    @Override
    String fight() {
        return String.format("I am %s and I am fighting !", this.getPseudo());
    }

}
