package com.smp.shootingrobot;

import com.badlogic.gdx.Game;


public class ShootingRobotGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}