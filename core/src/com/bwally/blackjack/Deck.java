package com.bwally.blackjack;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck = new Stack<Card>();
    private String[] faces = {"ACE", "ONE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    private String[] suits = {"CLUB", "SPADE", "DIAMOND", "HEART"};

    public Deck() {
        fillDeck();
    }

    private void fillDeck() {
        deck.push(new Card(new Face("ACE"), new Suit("CLUB")));
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void printDeck() {

        System.out.println(deck.get(0).getFace().getName() + " " + deck.get(0).getSuit().getName());
//        for (int i = 0; i < deck.size(); i++) {
//            System.out.println(deck.get(i).getSuit().getName() + " " + deck.get(i).getFace().getName());
//        }
    }

}
