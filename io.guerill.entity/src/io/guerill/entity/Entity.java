package io.guerill.entity;

import java.util.UUID;

import io.guerill.data.Position;

public class Entity
{
	private UUID uuid = UUID.randomUUID();
	private String name = null;
	private Position position = null;

	public Entity ( UUID uuid )
	{
		this.uuid = uuid;
		// TODO resolve local data first
	}

	public Entity ( String name )
	{
		this.name = name;
	}

	public Entity ( String name, Position position )
	{
		this( name );
		this.position = position;
	}

	public final UUID getId ()
	{
		return uuid;
	}

	public final String getName ()
	{
		return name;
	}

	public final void setName ( String name )
	{
		this.name = name;
	}

	public final Position getPosition ()
	{
		return position;
	}

	public final void setPosition ( Position position )
	{
		this.position = position;
	}
}
