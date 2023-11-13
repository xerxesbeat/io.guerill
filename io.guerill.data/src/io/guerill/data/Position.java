package io.guerill.data;

import net.xerxesbeat.util.data.Vector2;

public class Position
{
	Vector2<Long> coordinates = new Vector2<Long> ( 0l, 0l );

	public Position () {}

	public Position ( long x, long y )
	{
		coordinates.set( x, y );
	}

	public long getX ()
	{
		return coordinates.getX();
	}

	public long getY ()
	{
		return coordinates.getY();
	}
}
