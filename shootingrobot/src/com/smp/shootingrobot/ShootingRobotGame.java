package com.smp.shootingrobot;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ShootingRobotGame extends Game
{

	@Override
	public void create()
	{
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose()
	{
		super.dispose();
		AssetLoader.dispose();
	}
}