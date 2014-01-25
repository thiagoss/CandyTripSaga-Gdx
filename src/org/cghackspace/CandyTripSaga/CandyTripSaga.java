package org.cghackspace.CandyTripSaga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CandyTripSaga extends Game {
	SpriteBatch batch;
	BitmapFont font;
	
	static int WINDOW_WIDTH = 1024;
	static int WINDOW_HEIGHT = 768;
	
	@Override
	public void create() {		
		batch = new SpriteBatch();

		font = new BitmapFont();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {
		super.render();
	}
}
