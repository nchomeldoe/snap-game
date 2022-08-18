package org.example;

public class Player {
    String name;
    boolean winner;

    public Player(String name) {
        this.name = name;
        this.winner = false;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

}
