package org.example;

import java.util.ArrayList;
import java.util.List;

public class CardDeckFactory {
    public static List<Card> createDeckOfCards() {
        List<Card> deckOfCards = new ArrayList<>();
        Suit[] suits = new Suit[]{Suit.spades, Suit.hearts, Suit.diamonds, Suit.clubs};
        for (Suit suit : suits) {
            for (int i = 2; i < 15; i++) {
                deckOfCards.add(new Card(suit, i));
            }
        }
        return deckOfCards;
    }
}
