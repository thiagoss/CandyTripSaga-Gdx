package org.cghackspace.CandyTripSaga;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Kid extends Actor {

	private static final float MOVEMENT = 5f;

	private static final float RUNNING_FRAME_DURATION = 0.1f;

	TextureRegion idleRight;
	TextureRegion idleLeft;
	TextureRegion idleUp;
	TextureRegion idleDown;
	Animation walkRight;
	Animation walkLeft;
	Animation walkUp;
	Animation walkDown;

	char direction;
	boolean idle = true;

	float stateTime = 0;

	public Kid() {
		this.setBounds(0, 0, 64, 64);
		direction = 'r';

		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("kurttextures.pack"));
		idleRight = atlas.findRegion("r000");
		idleLeft = new TextureRegion(idleRight);
		idleLeft.flip(true, false);
		idleUp = atlas.findRegion("u000");
		idleDown = atlas.findRegion("d000");

		TextureRegion[] walkLeftFrames = new TextureRegion[4];
		for (int i = 0; i <= 3 ; i++) {
			walkLeftFrames[i] = atlas.findRegion("l00" + i);
		}
		walkLeft = new Animation(RUNNING_FRAME_DURATION, walkLeftFrames);

		TextureRegion[] walkRightFrames = new TextureRegion[4];
		for (int i = 0; i <= 3; i++) {
			walkRightFrames[i] = new TextureRegion(walkLeftFrames[i]);
			walkRightFrames[i].flip(true, false);
		}
		walkRight = new Animation(RUNNING_FRAME_DURATION, walkRightFrames);

		TextureRegion[] walkUpFrames = new TextureRegion[2];
		for (int i = 0; i <= 1; i++) {
			walkUpFrames[i] = new TextureRegion(atlas.findRegion("u00" + i));
		}
		walkUp = new Animation(RUNNING_FRAME_DURATION, walkUpFrames);

		TextureRegion[] walkDownFrames = new TextureRegion[2];
		for (int i = 0; i <= 1; i++) {
			walkDownFrames[i] = new TextureRegion(atlas.findRegion("d00" + i));
		}
		walkDown = new Animation(RUNNING_FRAME_DURATION, walkDownFrames);
	}

	public void draw (SpriteBatch batch, float parentAlpha) {
		if(idle) {
			switch(direction) {
			case 'l':
				batch.draw(idleLeft, getX(), getY());
				break;
			case 'u':
				batch.draw(idleUp, getX(), getY());
				break;
			case 'd':
				batch.draw(idleDown, getX(), getY());
				break;
			case 'r':
			default:
				batch.draw(idleRight, getX(), getY());
				break;
			}
		} else {
			TextureRegion f = null;
			switch(direction) {
			case 'l':
				f = walkLeft.getKeyFrame(stateTime, true);
				break;
			case 'u':
				f = walkUp.getKeyFrame(stateTime, true);
				break;
			case 'd':
				f = walkDown.getKeyFrame(stateTime, true);
				break;
			case 'r':
			default:
				f = walkRight.getKeyFrame(stateTime, true);
				break;
			}
			batch.draw(f, getX(), getY());
		}
	}

	public void act(float delta) {
		stateTime += delta;
		super.act(delta);
		handleInput();
		clampToBounds(0, 0, getStage().getWidth(), getStage().getHeight());
	}

	public void handleInput() {
		idle = true;
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			idle = false;
			setY(getY() - MOVEMENT);
			direction = 'd';
		} else if(Gdx.input.isKeyPressed(Keys.UP)) {
			idle = false;
			setY(getY() + MOVEMENT);
			direction = 'u';
		}	
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			idle = false;
			setX(getX() + MOVEMENT);
			direction = 'r';
		} else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			idle = false;
			setX(getX() - MOVEMENT);
			direction = 'l';
		}
	}

	public void clampToBounds(float x0, float y0, float x1, float y1) {
		if (getX() < x0) setX(x0);
		else if (getX() + getWidth() > x1) setX(x1 - getWidth());

		if (getY() < y0) setY(y0);
		else if (getY() + getHeight() > y1) setY(y1 - getHeight());
	}

	public void dispose() {
	}

}
