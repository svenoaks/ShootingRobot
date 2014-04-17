package com.smp.shootingrobot;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import static com.smp.shootingrobot.Constants.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static int DIMENSION_SCREEN_HEIGHT = 408;
	public static int DIMENSION_SCREEN_WIDTH = 272;
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "shootingrobot";
		cfg.useGL20 = false;
		cfg.width = DIMENSION_SCREEN_WIDTH;
		cfg.height =DIMENSION_SCREEN_HEIGHT;
		
		new LwjglApplication(new ShootingRobotGame(), cfg);
	}
}