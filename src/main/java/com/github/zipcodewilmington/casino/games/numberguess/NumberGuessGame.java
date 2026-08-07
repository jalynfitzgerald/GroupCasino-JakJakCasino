package com.github.zipcodewilmington.casino.games.numberguess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
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
        for (PlayerInterface player : players) {
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);

            int secretNumber = random.nextInt(100) + 1;
            int guesses = 0;

            while (true) { 
                System.out.println("======================");
                System.out.println("Guess a number between 1 and 100!");
                System.out.println("======================");
                System.out.println("Guesses so far: " + guesses);

                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                guesses++;

                //check if the guess is correct
                if (guess == secretNumber) {
                    System.out.println ("Congradulations! You guessed the number!");
                    break;
                }

                //Guess the number to low
                if (guess < secretNumber) {
                    System.out.println("To low :(");
                }

            // guess was to high

            if (guess > secretNumber) {
                System.out.println("Bring it down some!");
            }

            if (guesses == 15) {
                System.out.println("=========================");
                System.out.println("GAME OVER!");
                System.out.println("You've used all 15 guesses");
                System.out.println("The secret number was:" + secretNumber);
                break;
            }
             
        
            }
        }
}

