package com.smp.shootingrobot;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor
{
	private Bird bird;
	private GameWorld world;
	
	public InputHandler(GameWorld world)
	{
		this.world = world;
		this.bird = world.getBird();
	}
	@Override
	public boolean keyDown(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		if (world.isReady())
		{
			world.start();
		}
		
		bird.onClick();
		
		if (world.isGameOver() ||world.isHighScore())
		{
			world.restart();
		}
        return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
