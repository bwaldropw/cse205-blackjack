package com.bwally.blackjack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Hand extends Deck {
    private ArrayList<Card> hand;
    private int total;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard() {
        hand.add(drawCard());
    }

    public void setCardPosition() {
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).x = 100;
        }
        for (int i = 0; i < hand.size(); i++) {
            Card current = hand.get(i);
            current.x += current.x + (i * 135);
        }
    }

    public void drawHand(SpriteBatch batch) {
        setCardPosition();
        for (int i = 0; i < hand.size(); i++) {
            Card current = hand.get(i);
            batch.draw(current.getTexture(), current.x, current.y, current.width, current.height);
        }
    }

    public void updateTotal() {
        total = 0;
        // fixme switch ace if > 21
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getFace().getValue();
        }
    }

    public int getTotal() {
        updateTotal();
        return total;
    }

    public void printHand() {
        System.out.println("HAND PRINTED");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).getFace().getName() + " " + hand.get(i).getSuit().getName());
        }
    }
}
