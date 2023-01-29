package com.bwally.blackjack;

//fixme REMOVE PHILLIP MILLERS FACE

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture arm;

	private FreeTypeFontGenerator fontGenerator;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
	private BitmapFont font;
	Deck testDeck;
	Hand testHand;


	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.jpg");
		arm = new Texture("arm.png");

		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Purple Smile.ttf"));
		fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter.size = 50;
		fontParameter.borderWidth = 5;
		fontParameter.borderColor = Color.BLACK;
		fontParameter.color = Color.WHITE;
		font = fontGenerator.generateFont(fontParameter);

		testHand = new Hand();
		testHand.addCard();
		testHand.addCard();
		testHand.addCard();
		testHand.printHand();
		System.out.println(testHand.getTotal());
	}

	@Override
	public void render () {
		ScreenUtils.clear(255, 255, 255, 1);

		batch.begin();

		batch.draw(background, 0, 0); //fixme [testing] delete later
		testHand.drawHand(batch);
		font.draw(batch, "Total: " + testHand.getTotal(), 100, 100);

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			batch.draw(arm, 300, 0);
		}
		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
