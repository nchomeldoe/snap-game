package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    public Snap(String name) {
        super(name);
        this.numberOfPlayers = 1;
    }

    public Snap(String name, int numberOfPlayers) {
        super(name, numberOfPlayers);
    }


    public Card playTurn() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine() != null) {
            Card cardDealt = dealCard();
            setDeckOfCards(deckOfCards.subList(1, deckOfCards.size()));
            deckOfCards.remove(0);
            System.out.println(cardDealt);
            System.out.println();
            return cardDealt;
        }
        return null;
    }

    public void resetDeck() {
        setDeckOfCards(CardDeckFactory.createDeckOfCards());
        shuffleDeck();
    }


    protected void playSinglePlayerGame() {
        shuffleDeck();
        System.out.println("Press enter each time to deal a new card");
        Card firstCard = playTurn();
        Card secondCard = playTurn();
        while (!firstCard.getSymbol().equals(secondCard.getSymbol())) {
            firstCard = secondCard;
            secondCard = playTurn();
            if (getDeckOfCards().size() == 0) {
                resetDeck();
            }
        }
        System.out.println("Game Over!");
    }


    protected void playMultiPlayerGame() {
        shuffleDeck();
        boolean gameOver = false;
        Card existingCard = null;
        ArrayList<Player> players = PlayerFactory.createPlayers(this.numberOfPlayers);
        while (!gameOver) {
            for (Player player : players) {
                if (getDeckOfCards().size() == 0) {
                    resetDeck();
                    existingCard = null;
                }
                System.out.println(player.getName() + ", press enter to take your turn:");
                if (existingCard == null) {
                    existingCard = playTurn();
                } else {
                    Card newCard = playTurn();
                    if (existingCard.getSymbol().equals(newCard.getSymbol())) {
                        gameOver = true;
                        player.setWinner(true);
                        System.out.println(player.getName() + " wins! Game over!");
                        break;
                    } else {
                        existingCard = newCard;
                    }

                }
            }
        }
    }

    public void playGame() {
        if(numberOfPlayers > 1) {
            playMultiPlayerGame();
        } else {
            playSinglePlayerGame();
        }
    }
}
