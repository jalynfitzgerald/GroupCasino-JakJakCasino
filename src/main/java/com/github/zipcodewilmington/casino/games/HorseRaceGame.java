package com.github.zipcodewilmington.casino.games.horserace;

import java.util.ArrayList;
import java.util.List;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class HorseRaceGame implements GameInterface {
    private final List<PlayerInterface> players = new ArrayList<>();

    @Override
    public void add(PlayerInterface player) {
        players.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

    @Override
    public void run() {
        HorseRace horse1 = new HorseRace("Virtual Matt");
        HorseRace horse2 = new HorseRace("Terrick");
        HorseRace horse3 = new HorseRace("Jaymoney");
        HorseRace horse4 = new HorseRace("Idris");
        HorseRace horse5 = new HorseRace("Tango");
        HorseRace horse6 = new HorseRace("Anymeenz");

        List<HorseRace> horses = new ArrayList<>();

    horses.add(horse1);
    horses.add(horse2);
    horses.add(horse3);
    horses.add(horse4);
    horses.add(horse5);
    horses.add(horse6);

    System.out.println("===========================");
    System.out.println("   JakJak Horse Race Game!");
    System.out.println("===========================");
    System.out.println("Choose your horse:");
    System.out.println("1. Virtual Matt");
    System.out.println("2. Terrick");
    System.out.println("3. Jaymoney");
    System.out.println("4. Idris ");
    System.out.println("5. Tango");
    System.out.println("6. Anymeenz");
    System.out.println("Enter your choice (1-6): ");

    int choice = scanner.nextInt();

    HorseRace selectedHorse = null;

    switch (choice) {
        case 1:
            selectedHorse = horse1;
            break;
        case 2:
            selectedHorse = horse2;
            break;
        case 3:
            selectedHorse = horse3;
            break;
        case 4:
            selectedHorse = horse4;
            break;
        case 5:
             selectedHorse = horse5;
             break;
        case 6:
            selectedHorse = horse6;
            break;
        default:
            System.out.println("Invalid choice.");
            return;                         
    }

    System.out.println("You chose:" + selectedHorse.getName());

     
        boolean raceOver = false;

        while (!raceOver) {

            for (HorseRace horse : horses) {
                horse.move();

                if (horse.getPosition() >= 150) {
                    
                    raceOver = true;

                    System.out.println("Winner: " + horse.getName());

                    if (horse == selectedHorse) {
                        System.out.println("CONGRADULATIONS! Your horse won!");
                    } else {
                        System.out.println("Better luck next race :(");
                    }

                    break;
                }
            }
        }
    }
}

}
