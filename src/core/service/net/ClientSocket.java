package core.service.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class ClientSocket extends Thread {
	private Socket _socket;
	private Queue<String> _serverMessages;
	private BufferedReader _inputFromServer;
	private DataOutputStream _outputToServer;
	
	public final static int SERVER_PORT = 95;
	public final static String SERVER_IP = "";
	
	public ClientSocket() {
		_serverMessages = new LinkedList<String>();
	}
	
	public boolean connect() {
		try {
			_socket = new Socket(SERVER_IP, SERVER_PORT);
			_inputFromServer = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			_outputToServer = new DataOutputStream(_socket.getOutputStream());
			this.start();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean disconnect() {
		try {
			_socket.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean write(String message) {
		try {
			_outputToServer.writeBytes(message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
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
	
	@Override
	public void run() {
		boolean exit = false;
		
		while (!exit) {
			String checker = null;
			String serverMessage = null;
			
			do {
				try {
					checker = _inputFromServer.readLine();
					if (checker != null) 
						serverMessage += checker;
				} catch (IOException e) {
					e.printStackTrace();
					exit = false;
				}
				
			} while (checker != null && !exit);
			
			if (!exit)
				_serverMessages.add(serverMessage);
		}
	}
}
