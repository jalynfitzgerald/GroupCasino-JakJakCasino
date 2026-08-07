package com.github.zipcodewilmington.casino.games.roulette;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RouletteGame implements GameInterface {

    private RouletteWheel wheel;
    private List<PlayerInterface> players;

    public RouletteGame() {
        this.wheel = new RouletteWheel();
        this.players = new ArrayList<>();
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

        int winningNumber = wheel.spin();

        RouletteBetType winningColor = getWinningColor(winningNumber);

        for (PlayerInterface playerInterface : players) {

            RoulettePlayer player = (RoulettePlayer) playerInterface;

            boolean winner = false;

            if (player.getBetType() == RouletteBetType.NUMBER) {

                winner = player.getSelectedNumber() == winningNumber;

            } else {

                winner = player.getBetType() == winningColor;

            }

            if (winner) {

                player.getArcadeAccount()
                        .deposit(BigDecimal.valueOf(player.getBetAmount() * 2));

                System.out.println("Winner!");
                System.out.println("Winning Number: " + winningNumber);
                System.out.println("Winning Color: " + winningColor);

            } else {

                System.out.println("You Lost!");
                System.out.println("Winning Number: " + winningNumber);
                System.out.println("Winning Color: " + winningColor);

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