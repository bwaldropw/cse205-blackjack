package com.bwally.blackjack;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;

public class Card {
    private Face face;
    private Suit suit;
    private Texture texture;

    public final int width = 125;
    public final int height = 175;

    public int x = 100;
    public int y = 100;

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

    public Texture getTexture() {
        return texture;
    }

    private Texture createTexture(Face face, Suit suit) {
        Texture cardBlank = new Texture("CARD.png");
        Texture cardFace = new Texture(this.face.getName() + ".png");
        Texture cardSuit = new Texture(this.suit.getName() + ".png");

        cardBlank.getTextureData().prepare();
        Pixmap cardMap = cardBlank.getTextureData().consumePixmap();

        cardFace.getTextureData().prepare();
        Pixmap faceMap = cardFace.getTextureData().consumePixmap();

        cardSuit.getTextureData().prepare();
        Pixmap suitMap = cardSuit.getTextureData().consumePixmap();

        cardMap.drawPixmap(faceMap, 25, 25);
        cardMap.drawPixmap(suitMap, 5, 5);

        Texture texture = new Texture(cardMap);

        cardMap.dispose();
        faceMap.dispose();
        suitMap.dispose();

        return texture;
    }
}
