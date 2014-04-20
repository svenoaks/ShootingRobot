package com.smp.shootingrobot;

public class Grass extends Scrollable {

	public Grass(float x, float y, float width, float height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);
	}

	public void onRestart(float x, float scrollSpeed) {
		position.x = x;
		velocity.x = scrollSpeed;
	}

}
