package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerFactory {
    public static ArrayList<Player> createPlayers(int numberOfPlayers) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("PLayer " + i + ", please enter your name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        return players;
    }
}
