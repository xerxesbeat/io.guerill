package io.guerill.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import io.guerill.server.session.Session;

public class GuerillioSession extends Session
{
	private String buffer = "foobar";

	public GuerillioSession ( Socket socket )
	{
		super( socket );
	}

	@Override
	public void read ( InputStream input )
	{
		try
		{
			while ( input.available() > 0 )
			{
				System.out.print( (char) input.read() );
			}
			System.out.println();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public void write ( OutputStream output )
	{
		try
		{
			if ( buffer != null )
			{
				output.write( buffer.getBytes() );
				buffer = null;
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}
}
