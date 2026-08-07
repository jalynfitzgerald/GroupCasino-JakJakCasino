package com.github.zipcodewilmington.casino.games.roulette;

public class RouletteResult {

    private boolean winner;
    private int winningNumber;
    private RouletteBetType winningColor;

    public RouletteResult(boolean winner, int winningNumber, RouletteBetType winningColor) {

        this.winner = winner;
        this.winningNumber = winningNumber;
        this.winningColor = winningColor;
    }

    public boolean isWinner() {
        return winner;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public RouletteBetType getWinningColor() {
        return winningColor;
    }
}