package com.github.zipcodewilmington.casino.games.roulette;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class RouletteGame implements GameInterface {

    private RouletteWheel wheel;
    private List<PlayerInterface> players;
    private IOConsole console;

    public RouletteGame() {
        this.wheel = new RouletteWheel();
        this.players = new ArrayList<>();
        this.console = new IOConsole(AnsiColor.GREEN);
    }

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

        console.println("====== ROULETTE ======");
        console.println("1. Bet on Number");
        console.println("2. Bet on Red");
        console.println("3. Bet on Black");

        String choice = console.getStringInput("Choose your bet:");

        int amount = Integer.parseInt(
                console.getStringInput("Enter bet amount:")
        );

        int winningNumber = wheel.spin();
        RouletteBetType winningColor = getWinningColor(winningNumber);

        for (PlayerInterface playerInterface : players) {

            RoulettePlayer player = (RoulettePlayer) playerInterface;

            if (choice.equals("1")) {

                int number = Integer.parseInt(
                        console.getStringInput("Choose a number (0-36):")
                );

                player.placeBet(RouletteBetType.NUMBER, number, amount);

            } else if (choice.equals("2")) {

                player.placeBet(RouletteBetType.RED, 0, amount);

            } else {

                player.placeBet(RouletteBetType.BLACK, 0, amount);

            }

            boolean winner;

            if (player.getBetType() == RouletteBetType.NUMBER) {

                winner = player.getSelectedNumber() == winningNumber;

            } else {

                winner = player.getBetType() == winningColor;

            }

            if (winner) {

                int payout;

                if (player.getBetType() == RouletteBetType.NUMBER) {
                    payout = player.getBetAmount() * 35;
                } else {
                    payout = player.getBetAmount() * 2;
                }

                player.getCasinoAccount()
                        .deposit(BigDecimal.valueOf(payout));

                console.println("-------------------------");
                console.println("Winner!");
                console.println("Winning Number: " + winningNumber);
                console.println("Winning Color: " + winningColor);
                console.println("You won $" + payout);
                console.println("-------------------------");

            } else {

                console.println("-------------------------");
                console.println("You Lost!");
                console.println("Winning Number: " + winningNumber);
                console.println("Winning Color: " + winningColor);
                console.println("-------------------------");
            }
        }
    }

    private RouletteBetType getWinningColor(int winningNumber) {

        if (winningNumber == 0) {
            return RouletteBetType.GREEN;
        }

        switch (winningNumber) {

            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 12:
            case 14:
            case 16:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 27:
            case 30:
            case 32:
            case 34:
            case 36:
                return RouletteBetType.RED;

            default:
                return RouletteBetType.BLACK;
        }
    }
}