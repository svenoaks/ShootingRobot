package com.smp.shootingrobot;

import com.badlogic.gdx.math.Vector2;

public class PlayerShot extends BaseShot
{
	private static final float DIMENSION_WIDTH = 10;
	private static final float DIMENSION_HEIGHT = 8;
	
	private static final float VECTOR_MAGNITUDE = 100;
	
	public PlayerShot()
	{
		width = DIMENSION_WIDTH;
		height = DIMENSION_HEIGHT;
	}
	
	public void setVelocity(float rotation)
	{
		float absRotation = Math.abs(rotation);
		
		float x = (float) Math.cos(degToRad(absRotation)) * VECTOR_MAGNITUDE;
		float y = (float) Math.sin(degToRad(absRotation)) * VECTOR_MAGNITUDE;
		
		if (rotation < 0) 
			y = -y;
		
		velocity = new Vector2(x, y);
	}
	
	private float degToRad(float radians)
	{
		return radians * ((float)Math.PI / 180.0f);
	}
}
