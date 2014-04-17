package com.smp.shootingrobot;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import static com.smp.shootingrobot.Constants.*;

public class GameWorld
{
	public enum GameState
	{
		READY, RUNNING, GAMEOVER, HIGHSCORE
	}

	private GameState currentState;
	private Bird bird;
	private ScrollHandler scroller;
	private Rectangle ground;
	private int score;
	private int midPointY;

	public int getScore()
	{
		return score;
	}

	public void addScore(int increment)
	{
		score += increment;
	}

	public GameWorld(int midPointY)
	{
		currentState = GameState.READY;
		this.midPointY = midPointY;
		bird = new Bird(DIMENSION_BIRD_X_POSITION, midPointY - DIMENSION_BIRD_STARTING_BELOW_MID,
				DIMENSION_BIRD_WIDTH, DIMENSION_BIRD_HEIGHT);
		scroller = new ScrollHandler(this, midPointY + 66);
		ground = new Rectangle(0, midPointY + 66, 136, 11);
	}

	public void update(float delta)
	{

		switch (currentState)
		{
			case READY:
				updateReady(delta);
				break;

			case RUNNING:
				updateRunning(delta);
				break;
			default:
				break;
		}

	}

	private void updateReady(float delta)
	{

	}

	public void updateRunning(float delta)
	{
		bird.update(delta);
		scroller.update(delta);

		if (scroller.collides(bird) && bird.isAlive())
		{
			scroller.stop();
			bird.die();
			AssetLoader.dead.play();
		}
		if (Intersector.overlaps(bird.getBoundingCircle(), ground))
		{
			scroller.stop();
			bird.die();
			bird.decelerate();
			currentState = GameState.GAMEOVER;

			if (score > AssetLoader.getHighScore())
			{
				AssetLoader.setHighScore(score);
				currentState = GameState.HIGHSCORE;
			}
		}
	}

	public boolean isHighScore()
	{
		return currentState == GameState.HIGHSCORE;
	}

	public boolean isReady()
	{
		return currentState == GameState.READY;
	}

	public void start()
	{
		currentState = GameState.RUNNING;
	}

	public void restart()
	{
		currentState = GameState.READY;
		score = 0;
		bird.onRestart(midPointY - 5.0f);
		scroller.onRestart();
		currentState = GameState.READY;
	}

	public Bird getBird()
	{
		return bird;
	}

	public ScrollHandler getScroller()
	{
		return scroller;
	}

	public boolean isGameOver()
	{
		return currentState == GameState.GAMEOVER;
	}
}
