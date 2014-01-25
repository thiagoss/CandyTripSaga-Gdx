package org.cghackspace.CandyTripSaga;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {

	final CandyTripSaga game;
	Stage stage;
	private Kid kid;
	
	public GameScreen(CandyTripSaga game) {
		this.game = game;
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		kid = new Kid();
		stage.addActor(kid);
		stage.setKeyboardFocus(kid);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(CandyTripSaga.WINDOW_WIDTH,
				CandyTripSaga.WINDOW_HEIGHT, false);

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
		stage.dispose();
		kid.dispose();
	}

}
