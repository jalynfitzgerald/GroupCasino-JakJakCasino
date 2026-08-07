package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;

public class RouletteWheel {

    private Random random;

    public RouletteWheel() {
        this.random = new Random();
    }

    public int spin() {
        return random.nextInt(37);
    }
}