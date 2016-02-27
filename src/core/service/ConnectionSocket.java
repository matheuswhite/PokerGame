package core.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionSocket {
	private Socket _socket;
	private boolean _isConnected;
	
	private ListenerFromServer _listener;
	private BufferedReader _inputFromServer;
	private Queue<String> _messagesFromServer;
	
	private DataOutputStream _outputToServer;
	
	public final static int SERVER_PORT = 95;
	public final static String SERVER_IP = "";
	
	public ConnectionSocket() {
		_messagesFromServer = new LinkedList<String>();
	}
	
	public void connect() {
		try {
			if (!_isConnected) {
				_socket = new Socket(SERVER_IP, SERVER_PORT);
				_inputFromServer = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
				_listener = new ListenerFromServer(_inputFromServer, this);

				_listener.start();
				_isConnected = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if (_isConnected) {
				_socket.close();
				_isConnected = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String message) {
		try {
			if (_isConnected) {
				_outputToServer = new DataOutputStream(_socket.getOutputStream());
				_outputToServer.writeBytes(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String read() {
		return _messagesFromServer.poll();
	}
	
	public boolean isConnected()
	{
		return _isConnected;
	}

	public void addMessageFromServer(String serverMsg) {
		_messagesFromServer.add(serverMsg);
	}
}
