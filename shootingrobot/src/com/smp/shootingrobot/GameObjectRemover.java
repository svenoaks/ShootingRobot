package com.smp.shootingrobot;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class GameObjectRemover
{
	public static <T extends GameObject> void removeOutOfBounds (Pool<T> pool, Array<T> gos, Rectangle bounds) {
		float minX = bounds.x;
		float maxX = minX + bounds.width;
		float minY = bounds.y;
		float maxY = minY + bounds.height;
		for (int i = gos.size - 1; i >= 0; i--) {
			T go = gos.get(i);
			if (go.getX() >= maxX || go.getX() + go.width <= minX || go.getY() >= maxY || go.getY() + go.getHeight() <= minY) {
				gos.removeIndex(i);
				pool.free(go);
			}
		}
	}
}
