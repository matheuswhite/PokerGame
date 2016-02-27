package core.service.net;

import java.io.BufferedReader;
import java.io.IOException;

public class ListenerFromServer extends Thread{
	private BufferedReader _inputFromServer;
	private ConnectionSocket _connectionSocket;
	
	public ListenerFromServer(BufferedReader inputFromServer, ConnectionSocket connectionSocket) {
		_inputFromServer = inputFromServer;
		_connectionSocket = connectionSocket;
	}
	
	public void run() {
		while (true)
		{
			String _serverMsg = null;
			
			try {
				_serverMsg = _inputFromServer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			_connectionSocket.addMessageFromServer(_serverMsg);
		}
	}
}
