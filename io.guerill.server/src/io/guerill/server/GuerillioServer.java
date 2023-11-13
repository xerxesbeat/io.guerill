package io.guerill.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import io.guerill.Guerillio;
import io.guerill.server.session.Session;

public class GuerillioServer
{
	static boolean done = false;

	private static ServerSocket serverSocket;
	private static LinkedList<Session> sessions = new LinkedList<> ();

	public static void main ( String [] args )
	{
		try
		{
			serverSocket = new ServerSocket ( Guerillio.DEFAULT_PORT );
			new Thread () {
				@Override
				public void run ()
				{
					while ( !done )
					{
						try
						{
							for ( Session session : sessions )
							{
								try
								{
									if ( !session.isDone() )
										session.pump();
									else
										sessions.remove( session );
								}
								catch ( Exception e )
								{
									e.printStackTrace();
								}
							}
							Thread.sleep( 12 );
						}
						catch ( Exception e )
						{
							e.printStackTrace();
						}
					}
				}
			}.start();
			while ( !done )
			{
				try
				{
					registerSession( serverSocket.accept() );
				}
				catch ( Exception e )
				{
					e.printStackTrace();
				}
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

	protected static void registerSession ( Socket socket )
	{
		if ( socket == null )
			return;
		if ( socket.isClosed() )
			return;
		sessions.addLast( new GuerillioSession ( socket ) );
	}
}
