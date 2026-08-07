package com.github.zipcodewilmington.casino.games.roulette;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        for (PlayerInterface playerInterface : players) {

            RoulettePlayer player = (RoulettePlayer) playerInterface;

            System.out.println("\nBalance: $"
                    + player.getCasinoAccount().getBalance());

            System.out.println("1. Bet on a number");
            System.out.println("2. Bet on RED");
            System.out.println("3. Bet on BLACK");

            System.out.print("Choose bet type: ");
            int choice = scanner.nextInt();

            System.out.print("Enter wager amount: ");
            int betAmount = scanner.nextInt();

            boolean betPlaced = false;

            if (choice == 1) {

                System.out.print("Choose a number 0-36: ");
                int selectedNumber = scanner.nextInt();

                betPlaced
                        = player.placeNumberBet(selectedNumber, betAmount);

            } else if (choice == 2) {

                betPlaced
                        = player.placeColorBet(
                                RouletteBetType.RED,
                                betAmount
                        );

            } else if (choice == 3) {

                betPlaced
                        = player.placeColorBet(
                                RouletteBetType.BLACK,
                                betAmount
                        );

            } else {

                System.out.println("Invalid selection.");
                return;
            }

            if (!betPlaced) {
                System.out.println("Unable to place bet.");
                return;
            }

            int winningNumber = wheel.spin();

            RouletteBetType winningColor
                    = getWinningColor(winningNumber);

            boolean winner;

            if (player.getBetType() == RouletteBetType.NUMBER) {

                winner
                        = player.getSelectedNumber() == winningNumber;

            } else {

                winner
                        = player.getBetType() == winningColor;
            }

            System.out.println("\nWinning Number: " + winningNumber);
            System.out.println("Winning Color: " + winningColor);

            if (winner) {

                player.getCasinoAccount()
                        .deposit(player.getBetAmount() * 2);

                System.out.println("Winner!");

                player.getCasinoAccount()
                        .deposit(BigDecimal.valueOf(payout));

                System.out.println("You Lost!");
            }

            System.out.println("Balance: $"
                    + player.getCasinoAccount().getBalance());
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
