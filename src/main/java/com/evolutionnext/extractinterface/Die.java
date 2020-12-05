package com.evolutionnext.extractinterface;

import java.util.Objects;
import java.util.Random;


public class Die {
    private final Random random;
    private final Integer pip;

    public Die(Random random) {
        this(random, 1);
    }

    private Die(Random random, int pip) {
        Objects.requireNonNull(random,
                "A Random is required");
        this.random = random;
        this.pip = pip;
    }

    public int getPip() {
        return pip;
    }

    public Die roll() {
        return new Die(random,
                random.nextInt(6) + 1);
    }
}
