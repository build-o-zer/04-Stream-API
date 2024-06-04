package org.buildozers.streamapidojo.kata_05;

public class DeadException extends RuntimeException {

    public DeadException(String name) {
        super("I am " + name + " and I am dead, I can't fight !");
    }

}
