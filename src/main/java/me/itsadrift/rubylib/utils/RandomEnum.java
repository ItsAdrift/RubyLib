package me.itsadrift.rubylib.utils;

import java.util.Random;

public class RandomEnum<E extends Enum<E>> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random(E... exlcude) {
            E value = values[RND.nextInt(values.length)];
            for (E e: exlcude) {
                if (value == e)
                    return random(exlcude);
            }
            return value;
        }
}
