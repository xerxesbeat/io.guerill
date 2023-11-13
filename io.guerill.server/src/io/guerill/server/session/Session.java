package io.guerill.server.session;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import net.xerxesbeat.pump.Pumpable;

public abstract class Session implements Pumpable
{
	private Socket socket = null;

	public Session ( Socket socket )
	{
		this.socket = socket;
	}

	public abstract void read ( InputStream input );

	public abstract void write ( OutputStream output );

	@Override
	public final void pump ()
	{
		if ( socket == null )
			throw new NullPointerException ();
		if ( isDone() )
			return;
			//throw new IllegalStateException ( "Session already ended." );
		try
		{
			InputStream input = socket.getInputStream();
			read( input );
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		try
		{
			OutputStream output = socket.getOutputStream();
			write( output );
			output.flush();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean isDone ()
	{
		return socket.isClosed();
	}
}
