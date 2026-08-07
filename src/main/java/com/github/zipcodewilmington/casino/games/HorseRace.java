package com.github.zipcodewilmington.casino.games.horserace;

import java.util.Random;

public class HorseRace {
    private String name;
    private int position;

    public HorseRace(String name) {
        this.name= name;
        this.position = 0;
    }
    

    public void move () {
        Random random = new Random();
        position += random.nextInt(5) + 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
