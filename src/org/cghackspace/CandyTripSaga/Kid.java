package org.cghackspace.CandyTripSaga;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class Kid extends Actor {

	private static final float MOVEMENT = 5f;
	
	Texture image;
	
	public Kid() {
		image = new Texture(Gdx.files.internal("kurt_64x64_02.png"));
		this.setBounds(0, 0, image.getWidth(), image.getHeight());
	}
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		batch.draw(image, getX(), getY());
    }
	
	public void act(float delta) {
		super.act(delta);
		handleInput();
		clampToBounds(0, 0, getStage().getWidth(), getStage().getHeight());
	}
	
	
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			setX(getX() + MOVEMENT);
		} else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			setX(getX() - MOVEMENT);
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			setY(getY() - MOVEMENT);
		} else if(Gdx.input.isKeyPressed(Keys.UP)) {
			setY(getY() + MOVEMENT);
		}	
	}

	public void clampToBounds(float x0, float y0, float x1, float y1) {
		if (getX() < x0) setX(x0);
		else if (getX() + image.getWidth() > x1) setX(x1 - image.getWidth());
		
		if (getY() < y0) setY(y0);
		else if (getY() + image.getHeight() > y1) setY(y1 - image.getHeight());
	}

	public void dispose() {
		image.dispose();
	}

}
