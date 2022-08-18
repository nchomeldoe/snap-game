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
            deckOfCards.remove(0);
            System.out.println(cardDealt);
            return cardDealt;
        }
        return null;
    }

    public void resetDeck() {
        setDeckOfCards(CardDeckFactory.createDeckOfCards());
        shuffleDeck();
    }


    public void playGame() {
        shuffleDeck();
        Card firstCard = playTurn();
        Card secondCard = playTurn();
        while (!firstCard.getSymbol().equals(secondCard.getSymbol())) {
            firstCard = secondCard;
            secondCard = playTurn();
            if (getDeckOfCards().size() == 0) {
                resetDeck();
            }
        }
        System.out.println("Game Over! You win!");
    }

    public void playMultiPlayerGame() {
        ArrayList<Player> players = PlayerFactory.createPlayers(this.numberOfPlayers);
        shuffleDeck();
        boolean gameOver = false;
        Card firstCard = playTurn();
        Card secondCard = playTurn();
        while(!gameOver) {
            if(!firstCard.getSymbol().equals(secondCard.getSymbol())) {
                firstCard = secondCard;
                secondCard = playTurn();
                if (getDeckOfCards().size() == 0) {
                    resetDeck();
                }
            } else {
                gameOver = true;
                System.out.println("Game Over! You win!");
            }
        }
    }
}
