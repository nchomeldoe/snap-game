package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    protected boolean gameOver = false;

    protected boolean snapTimeUp = false;

    public Snap(String name) {
        super(name);
        this.numberOfPlayers = 1;
    }

    public Snap(String name, int numberOfPlayers) {
        super(name, numberOfPlayers);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isSnapTimeUp() {
        return snapTimeUp;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setSnapTimeUp(boolean snapTimeUp) {
        this.snapTimeUp = snapTimeUp;
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
        setGameOver(false);
        setSnapTimeUp(false);
        Card existingCard = null;
        try {
            ArrayList<Player> players = PlayerFactory.createPlayers(this.numberOfPlayers);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter snap within two seconds to win if your card has the same value as the last one played.");
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
                            Timer timer = new Timer();
                            TimerTask task = new TimerTask() {
                                @Override
                                public void run() {
                                    setSnapTimeUp(true);
                                    System.out.println("Time's up!");
                                }
                            };
                            timer.schedule(task, 2000);
                            String input = scanner.nextLine();
                            timer.cancel();
                            if (!isSnapTimeUp() && input.equalsIgnoreCase("snap")) {
                                setGameOver(true);
                                player.setWinner(true);
                                System.out.println(player.getName() + " wins! Game over!");
                                break;
                            } else {
                                System.out.println("Too late! Keep going!");
                            }
                        } else {
                            existingCard = newCard;
                        }

                    }
                }
            }
        } catch(IllegalArgumentException e) {
            System.out.println("please enter a name for each player");
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
