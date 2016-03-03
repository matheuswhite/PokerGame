package core.service.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class ClientSocket implements Runnable {
	private Socket _socket;
	private boolean _isConnected;
	private Queue<String> _serverMessages;
	private BufferedReader _inputFromServer;
	private DataOutputStream _outputToServer;
	
	public final static int SERVER_PORT = 95;
	public final static String SERVER_IP = "";
	
	public ClientSocket() {
		_serverMessages = new LinkedList<String>();
	}
	
	public void connect() throws UnknownHostException, IOException {
		if (!_isConnected) {
			_socket = new Socket(SERVER_IP, SERVER_PORT);
			_inputFromServer = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			_outputToServer = new DataOutputStream(_socket.getOutputStream());
			
			new Thread(this).start();
			_isConnected = true;
		}
	}
	
	public void disconnect() throws IOException {
		if (_isConnected) {
			_socket.close();
			_isConnected = false;
		}
	}
	
	public void write(String message) throws IOException {
		if (_isConnected) {
			_outputToServer.writeBytes(message);
		}
	}
	
	public Queue<String> readAll() {
		if (!_serverMessages.isEmpty()) {
			Queue<String> out = _serverMessages;
			_serverMessages.clear();
			return out;
		}
		return null;
	}
	
	public String read() {
		if (!_serverMessages.isEmpty()) {
			return _serverMessages.poll();
		}
		
		return null;
	}
	
	public boolean isConnected()
	{
		return _isConnected;
	}
	
	@Override
	public void run() {
		while (true) {
			String checker = null;
			String serverMessage = null;
			
			do {
				try {
					checker = _inputFromServer.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (checker != null) 
					serverMessage += checker;
			} while (checker != null);
			
			_serverMessages.add(serverMessage);
		}
	}
}
