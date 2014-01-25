package org.cghackspace.CandyTripSaga;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

	final CandyTripSaga game;
	private OrthographicCamera camera;
	private Kid kid;
	
	public GameScreen(CandyTripSaga game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, CandyTripSaga.WINDOW_WIDTH,
				CandyTripSaga.WINDOW_HEIGHT);
		
		kid = new Kid();
		kid.setPosition(20, CandyTripSaga.WINDOW_HEIGHT/2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		kid.draw(game.batch);
		game.batch.end();
		
		kid.handleInput();
		kid.clampToBounds(0, 0, CandyTripSaga.WINDOW_WIDTH,
				CandyTripSaga.WINDOW_HEIGHT);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		kid.dispose();

	}

}
