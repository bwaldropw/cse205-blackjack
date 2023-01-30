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

    public void setCardXPosition() {
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).x = 100;
        }
        // repositions distance between cards in hand on screen
        for (int i = 0; i < hand.size(); i++) {
            Card current = hand.get(i);
            current.x += current.x + (i * 135);
        }
    }

    public void setCardYPosition(int y) {
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).y = y;
        }
    }

    public void drawHand(SpriteBatch batch) {
        setCardXPosition();
        for (int i = 0; i < hand.size(); i++) {
            Card current = hand.get(i);
            batch.draw(current.getTexture(), current.x, current.y, current.width, current.height);
        }
    }

    public void updateTotal() {
        total = 0;
        // calculates total
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getFace().getValue();
        }

        // switches ace if total is > 21
        if (total > 21) {
            boolean includesAce = false;
            int indexOfAce = 0;

            // searches for ace
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getFace().getName().equals("ACE")) {
                    indexOfAce = i;
                    includesAce = true;
                }
            }
            if (includesAce) {
                hand.get(indexOfAce).getFace().switchAce();
            }

            // recalculates total
            total = 0;
            for (int i = 0; i < hand.size(); i++) {
                total += hand.get(i).getFace().getValue();
            }
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
