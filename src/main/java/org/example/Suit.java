package org.example;

public enum Suit {
    spades(1), hearts (2), diamonds(3), clubs(4);

    final int priority;

    Suit(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
