package org.buildozers.streamapidojo.kata_05;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class Kata05 {

    /**
     * returns a map containing the number of available fighters per team.
     * If a fighter is dead, it is not counted as an available fighter and a log message is printed when the method "fight" is called.
     * 
     * @param team list of teams
     * @return map of team and number of available fighters
     */

    public static Map<Team, Integer> getNumberAvailableFighters(List<Team> teams) {
        return teams.stream()
            .collect(Collectors.toMap(team -> team, 
                                      team ->  (int) team.getSuperHeroes().stream()
                                                    .map(TryFunction.of(AbstractSuperHero::fight))
                                                    .peek(tf -> tf.getException().ifPresent(e -> log.error("DeadException: " + e.getMessage())))
                                                    .filter(tf -> !tf.getException().isPresent())
                                                    .map(tf -> tf.getOriginalObject())                                             
                                                    .filter(AbstractSuperHero::isAlive)
                                                    .count()));
    }

    /**
     * Utility class to wrap a function and handle exceptions.
     * The function is applied to the original object and the result is stored in the value attribute.
     * If an exception is thrown, it is stored in the exception attribute.
     * If the function is applied to the original object, the original object is stored in the originalObject attribute.
     * 
     * The original object, and the possible exception and value are stored in the TryFunction object and can be accessed using the corresponding getter.
     */
    @RequiredArgsConstructor(staticName = "of")
    public static class TryFunction<T,V> implements Function<T, TryFunction<T,V>> {
        
        /**
         * The function to be wrapped, which would be applied to the original object.
         */
        private final Function<T,V> wrappedFunction;

        /**
         * The exception thrown by the wrapped function, if any.
         */
        @Getter
        private Optional<Exception> exception;

        /**
         * The value returned by the wrapped function, if no exception was thrown. 
         * Otherwise, the optional value is empty.
         */
        @Getter
        private Optional<V> value;

        /**
         * The original object to which the wrapped function was applied.
         * Can be accessed after the function is applied to the object.
         */
        @Getter
        private T originalObject;

        /**
         * Apply the wrapped function to the given object, acting as a proxy to the wrapped function,
         * but storing the original object, the exception and the value.
         */
        @Override
        public TryFunction<T,V> apply(T t) {
            originalObject = t;
            try {
                value = Optional.of(wrappedFunction.apply(t));
                exception = Optional.empty();
            } catch (Exception e) {
                exception = Optional.of(e);
                value = Optional.empty();
            }
            return this;
        }
    }

}
