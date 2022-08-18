package org.example;

public class Card  {
    private Suit suit;
    private String symbol;
    private int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
        if(value < 11 ) {
            this.symbol = String.valueOf(value);
        } else {
            switch(value) {
                case 11:
                    this.symbol = "J";
                    break;
                case 12:
                    this.symbol = "Q";
                    break;
                case 13:
                    this.symbol = "K";
                    break;
                case 14:
                    this.symbol = "A";
                    break;
            }
        }
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("suit='").append(suit).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }


}
