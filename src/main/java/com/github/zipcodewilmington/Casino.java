package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
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
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer(accountName, casinoAccount));
                    } else if (gameSelectionInput.equals("NUMBERGUESS")) {
                        play(new NumberGuessGame(), new NumberGuessPlayer(accountName, casinoAccount));
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountName, accountPassword));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
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