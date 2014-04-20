package com.smp.shootingrobot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;


public class GameScreen implements Screen {

	private static final float DIMENSION_SCREEN_WIDTH;
	private static final float DIMENSION_SCREEN_HEIGHT;
	private static final float DIMENSION_GAME_WIDTH;
	private static final float DIMENSION_GAME_HEIGHT;
	
	private static final int COORDINATE_MIDPOINT_Y;
	
	private static final Rectangle SHAPE_GAME_RECTANGLE;
	
	static
	{
		DIMENSION_GAME_WIDTH = 136;
		
		DIMENSION_SCREEN_WIDTH = Gdx.graphics.getWidth();
		DIMENSION_SCREEN_HEIGHT = Gdx.graphics.getHeight();
		
		DIMENSION_GAME_HEIGHT = DIMENSION_SCREEN_HEIGHT / 
				(DIMENSION_SCREEN_WIDTH / DIMENSION_GAME_WIDTH);
		
		COORDINATE_MIDPOINT_Y = (int) (DIMENSION_GAME_HEIGHT / 2);
		
		SHAPE_GAME_RECTANGLE = new Rectangle(0 ,0, DIMENSION_GAME_WIDTH, DIMENSION_GAME_HEIGHT);
	}
	
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;

	// This is the constructor, not the class declaration
	public GameScreen() {

		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();

		world = new GameWorld(COORDINATE_MIDPOINT_Y, SHAPE_GAME_RECTANGLE);
		Gdx.input.setInputProcessor(new InputHandler(world, DIMENSION_GAME_WIDTH, 
				screenWidth / DIMENSION_GAME_WIDTH, 
				screenHeight / DIMENSION_GAME_HEIGHT));
		renderer = new GameRenderer(world, DIMENSION_GAME_WIDTH, 
				DIMENSION_GAME_HEIGHT, 
				COORDINATE_MIDPOINT_Y);
		world.setRenderer(renderer);
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
