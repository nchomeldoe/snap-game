package org.example;

import java.util.ArrayList;

public class CardDeckFactory {
    public static ArrayList<Card> createDeckOfCards() {
        ArrayList<Card> deckOfCards = new ArrayList<>();
        Suit[] suits = new Suit[]{Suit.spades, Suit.hearts, Suit.diamonds, Suit.clubs};
        for (Suit suit : suits) {
            for (int i = 2; i < 15; i++) {
                deckOfCards.add(new Card(suit, i));
            }
        }
        return deckOfCards;
    }
}
