package com.github.zipcodewilmington.casino.games.horserace;

public class HorseRacePlayer {
    private HorseRace selectedHorse;

    public HorseRacePlayer(HorseRace selectHorse) {
        this.selectedHorse = selectHorse;
    }
    
    public HorseRace getSelectedHorse() {
        return selectedHorse;
    }
}
