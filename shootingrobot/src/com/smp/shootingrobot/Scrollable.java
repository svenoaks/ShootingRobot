package com.smp.shootingrobot;

import com.badlogic.gdx.math.Vector2;

public class Scrollable extends GameObject {
	
	protected boolean isScrolledLeft;

	public Scrollable(float x, float y, float width, float height, float scrollSpeed) {
		position = new Vector2(x, y);
		velocity = new Vector2(scrollSpeed, 0);
		this.width = width;
		this.height = height;
		isScrolledLeft = false;
	}
	
	@Override
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));

		// If the Scrollable object is no longer visible:
		if (position.x + width < 0) {
			isScrolledLeft = true;
		}
	}

	// Reset: Should Override in subclass for more specific behavior.
	public void reset(float newX) {
		position.x = newX;
		isScrolledLeft = false;
	}

	public void stop() {
		velocity.x = 0;
	}
	
	// Getters for instance variables
	public boolean isScrolledLeft() {
		return isScrolledLeft;
	}

	

}
