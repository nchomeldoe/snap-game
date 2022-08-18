package org.example;

public class Main {
    public static void main(String[] args) {
//        CardGame myCardGame = new CardGame("test");
//        System.out.println(myCardGame.getDeckOfCards());
//        System.out.println(myCardGame.shuffleDeck());
//        System.out.println(myCardGame.shuffleDeck());
//        System.out.println(myCardGame.shuffleDeck());
//        System.out.println(myCardGame.getDeckOfCards());
//        System.out.println(myCardGame.sortDeckInNumberOrder());
//        System.out.println(myCardGame.sortDeckIntoSuits());
//        System.out.println(myCardGame.dealCard().getSuit());

//        ArrayList<Card> originalOrder = myCardGame.getDeckOfCards();
//        ArrayList<Card> numberOrder = myCardGame.sortDeckInNumberOrder();
//        ArrayList<Card> suitOrder = myCardGame.sortDeckIntoSuits();
//
//        System.out.println(originalOrder.equals(suitOrder));
//        Snap snapObject = new Snap("gameOne");
//        System.out.println(snapObject.getName());
//        System.out.println(snapObject.getDeckOfCards());
//        System.out.println(snapObject.getDeckOfCards().size());
//
//        snapObject.playGame();
//        System.out.println(snapObject.getDeckOfCards().size());

        Snap multiplayerSnapGame = new Snap("gameTwo", 3);
        multiplayerSnapGame.playMultiPlayerGame();


    }
}