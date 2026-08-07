package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class Casino implements Runnable {

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {

        String casinoDashboardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();

        do {

            casinoDashboardInput = getCasinoDashboardInput();

            switch (casinoDashboardInput) {

                case "1":

                    console.println("=== Create Account ===");

                    String accountName = console.getStringInput("Enter Account Name:");
                    String accountPassword = console.getStringInput("Enter Password:");

                    CasinoAccount newAccount =
                            casinoAccountManager.createAccount(accountName, accountPassword);

                    casinoAccountManager.registerAccount(newAccount);

                    console.println("Account Created Successfully!");

                    break;

                case "2":

                    accountName = console.getStringInput("Enter Account Name:");
                    accountPassword = console.getStringInput("Enter Password:");

                    CasinoAccount casinoAccount =
                            casinoAccountManager.getAccount(accountName, accountPassword);

                    if (casinoAccount == null) {
                        console.println("Invalid Login!");
                        break;
                    }

                    String gameChoice = getGameSelectionInput();

                    switch (gameChoice) {

                        case "1":
                           play(new RouletteGame(),
                            new RoulettePlayer(casinoAccount));
                            break;

                        case "2":
                            console.println("Slots Coming Soon...");
                            break;

                        case "3":
                            play(new BlackjackGame(),
                            new BlackjackPlayer(accountName, casinoAccount));
                            break;

                        case "4":
                            console.println("Craps Coming Soon...");
                            break;

                        case "5":
                            play(new NumberGuessGame(),
                                    new NumberGuessPlayer(accountName, casinoAccount));
                            break;

                        case "6":
                            console.println("Horse Race Coming Soon...");
                            break;

                        case "7":
                            console.println("Returning to Main Menu...");
                            break;

                        default:
                            console.println("Invalid Game Selection.");
                    }

                    break;

                case "3":

                    console.println("Thank you for visiting JakJak Casino!");
                    break;

                default:

                    console.println("Invalid Menu Choice.");
            }

        } while (!casinoDashboardInput.equals("3"));
    }

    private String getCasinoDashboardInput() {

        return console.getStringInput(
                new StringBuilder()
                        .append("\n==============================")
                        .append("\n        JAKJAK CASINO")
                        .append("\n==============================")
                        .append("\n1. Create Account")
                        .append("\n2. Login & Select Game")
                        .append("\n3. Exit")
                        .append("\n")
                        .append("\nEnter Choice:")
                        .toString());
    }

    private String getGameSelectionInput() {

        return console.getStringInput(
                new StringBuilder()
                        .append("\n==============================")
                        .append("\n        SELECT A GAME")
                        .append("\n==============================")
                        .append("\n1. Roulette")
                        .append("\n2. Slots")
                        .append("\n3. Blackjack")
                        .append("\n4. Craps")
                        .append("\n5. Number Guess")
                        .append("\n6. Horse Race")
                        .append("\n7. Return to Main Menu")
                        .append("\n")
                        .append("\nEnter Choice:")
                        .toString());
    }

    private void play(GameInterface game, PlayerInterface player) {

        game.add(player);
        game.run();
    }
}