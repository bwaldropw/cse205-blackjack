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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;

public class Game extends ApplicationAdapter {
	public SpriteBatch batch;

	Texture arm;

	private Texture background;
	private FreeTypeFontGenerator fontGenerator;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
	private BitmapFont font;

	Hand testHand;
	Hand testHand2;

	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("background.jpg");
		arm = new Texture("arm.png");

		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Purple Smile.ttf"));
		fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter.size = 30;
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

		testHand2 = new Hand();
		testHand2.addCard();
		testHand2.addCard();
		testHand2.addCard();
		testHand2.printHand();
		System.out.println(testHand2.getTotal());
	}

	@Override
	public void render() {
		ScreenUtils.clear(255, 255, 255, 1);
		batch.begin();
		batch.draw(background, 0, 0);

		//fixme [testing] delete later
		testHand.drawHand(batch);
		testHand2.setCardYPosition(300);
		testHand2.drawHand(batch);
		font.draw(batch, "House:\n   " + testHand2.getTotal(), 25, 420);
		font.draw(batch, "You:\n  " + testHand.getTotal(), 40, 220);

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			batch.draw(arm, 300, 0);
		}

		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		background.dispose();
	}
}
