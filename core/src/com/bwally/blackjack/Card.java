package com.bwally.blackjack;

import com.badlogic.gdx.graphics.Texture;

public class Card {
    private Face face;
    private Suit suit;
    private Texture texture;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
        this.texture = createTexture(face, suit);
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    private Texture createTexture(Face face, Suit suit) {
        Texture texture = new Texture(/* FIXME Add Pixmap */);
        return texture;
    }
}
