package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CardGame {
    protected List<Card> deckOfCards;
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

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public Card dealCard() {
        return this.getDeckOfCards().get(0);
    }

    public List<Card> sortDeckInNumberOrder() {
        List<Card> sortedInNumberOrder = this.getDeckOfCards().stream()
                .sorted((a, b) -> a.getValue() - b.getValue())
                .collect(Collectors.toList());
        this.setDeckOfCards(sortedInNumberOrder);
        return sortedInNumberOrder;
    }

    public List<Card> sortDeckIntoSuits() {
        List<Card> sortedIntoSuits = this.getDeckOfCards().stream()
                .sorted((a, b) -> a.getSuit().getPriority() - b.getSuit().getPriority())
                .collect(Collectors.toList());
        this.setDeckOfCards(sortedIntoSuits);
        return sortedIntoSuits;
    }

    public List<Card> shuffleDeck() {
        List<Card> deckOfCards = this.getDeckOfCards();
        Collections.shuffle(deckOfCards);
        setDeckOfCards(deckOfCards);
        return deckOfCards;
    }
}
