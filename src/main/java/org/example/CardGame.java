package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class CardGame {
    protected ArrayList<Card> deckOfCards;
    protected String name;
    protected int numberOfPlayers;

    public CardGame(String name) {
        this.deckOfCards = CardDeckFactory.createDeckOfCards();
        this.name = name;
        this.numberOfPlayers = 1;
    }

    public CardGame(String name, int numberOfPlayers) {
        this.deckOfCards = CardDeckFactory.createDeckOfCards();
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public Card dealCard() {
        return this.getDeckOfCards().get(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        ArrayList<Card> sortedInNumberOrder = (ArrayList<Card>) this.getDeckOfCards().stream()
                .sorted((a, b) -> a.getValue() - b.getValue())
                .collect(Collectors.toList());
        this.setDeckOfCards(sortedInNumberOrder);
        return sortedInNumberOrder;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        ArrayList<Card> sortedIntoSuits = (ArrayList<Card>) this.getDeckOfCards().stream()
                .sorted((a, b) -> a.getSuit().getPriority() - b.getSuit().getPriority())
                .collect(Collectors.toList());
        this.setDeckOfCards(sortedIntoSuits);
        return sortedIntoSuits;
    }

    public ArrayList<Card> shuffleDeck() {
        ArrayList<Card> deckOfCards = this.getDeckOfCards();
        Collections.shuffle(deckOfCards);
        setDeckOfCards(deckOfCards);
        return deckOfCards;
    }
}
