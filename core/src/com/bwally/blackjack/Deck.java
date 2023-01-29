package com.bwally.blackjack;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> deck = new Stack<Card>();
    private final String[] faces = {"ACE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    private final String[] suits = {"CLUB", "SPADE", "DIAMOND", "HEART"};

    public Deck() {
        fillDeck();
    }

    private void fillDeck() {
        for (int i = 0; i < faces.length; i++) {

            for (int j = 0; j < suits.length; j++) {
                deck.push(new Card(new Face(faces[i]), new Suit(suits[j])));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void printDeck() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i).getFace().getName() + " " + deck.get(i).getSuit().getName());
        }
    }

    public Card drawCard() {
        return deck.pop();
    }


}
