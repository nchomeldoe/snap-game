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
            if(name.length() == 0) {
                throw new IllegalArgumentException("Please enter a name");
            }
            players.add(new Player(name));


        }
        return players;
    }
}
