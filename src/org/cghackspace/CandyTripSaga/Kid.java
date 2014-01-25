package org.cghackspace.CandyTripSaga;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Kid {

	private static final int MOVEMENT = 10;
	int x;
	int y;
	Texture image;
	
	public Kid() {
		image = new Texture(Gdx.files.internal("kid.png"));
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(image, x, y);
	}

	public void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += MOVEMENT;
		} else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= MOVEMENT;
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			y -= MOVEMENT;
		} else if(Gdx.input.isKeyPressed(Keys.UP)) {
			y += MOVEMENT;
		}	
	}

	public void clampToBounds(int x0, int y0, int x1, int y1) {
		if (x < x0) x = x0;
		else if (x + image.getWidth() > x1) x = x1 - image.getWidth();
		
		if (y < y0) y = y0;
		else if (y + image.getHeight() > y1) y = y1 - image.getHeight();
	}

	public void dispose() {
		image.dispose();
	}

}
