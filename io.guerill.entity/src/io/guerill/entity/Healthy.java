package io.guerill.entity;

import java.util.UUID;

import io.guerill.data.Position;

public abstract class Healthy extends Entity
{
	private long hp = 100;

	public Healthy ( String name, Position position )
	{
		super( name, position );
	}

	public Healthy ( String name, Position position, UUID uuid )
	{
		super( uuid );
		setName( name );
		setPosition( position );
	}

	public void setHp ( long hp )
	{
		this.hp = hp;
	}

	public long getHp ()
	{
		return hp;
	}
}
