package core.service.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Observable;

public class ClientSocket extends Observable implements Runnable {
	private Socket _socket;
	private boolean _isConnected;
	private BufferedReader _inputFromServer;
	private DataOutputStream _outputToServer;
	
	public final static int SERVER_PORT = 95;
	public final static String SERVER_IP = "";
	
	public void connect() {
		try {
			if (!_isConnected) {
				_socket = new Socket(SERVER_IP, SERVER_PORT);
				_inputFromServer = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
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
	
	public Thread startListen() {
		Thread out = new Thread(this);
		out.start();
		return out;
	}
	
	public boolean isConnected()
	{
		return _isConnected;
	}

	@Override
	public void run() {
		while (true)
		{
			String _serverMsg = null;
			
			try {
				_serverMsg = _inputFromServer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			this.notifyObservers(new String(_serverMsg));
		}
	}
}
