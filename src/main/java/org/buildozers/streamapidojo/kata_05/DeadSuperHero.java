package org.buildozers.streamapidojo.kata_05;

import lombok.Builder;

/**
 * A dead super hero that can't fight.
 * If it tries to fight, it will throw a DeadException.
 */
public class DeadSuperHero extends AbstractSuperHero {

    @Builder
    public DeadSuperHero(String pseudo) {
        super(pseudo);
    }

    @Override
    boolean isAlive() {
        return false;
    }

    @Override
    String fight() {
        throw new DeadException(this.getPseudo());
    }

}
