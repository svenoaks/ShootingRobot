package com.smp.shootingrobot;

import com.badlogic.gdx.math.Vector2;

public class BaseShot extends GameObject {

	public BaseShot () {
		super();
	}

	public void fire (float x, float y) {
		position = new Vector2(x, y);
	}

	@Override
	public void update (float delta) {
		position.add(velocity.cpy().scl(delta));
	}
}
