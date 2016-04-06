package core.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Observable;

public class ServerConnection extends Observable implements Runnable {
	private Socket _socket;
	private BufferedReader _inputFromServer;
	private DataOutputStream _outputToServer;
	
	public static final String DISCONNECT_MESSAGE = "";
	public final static int SERVER_PORT = 1095;
	public final static String SERVER_IP = "127.0.0.1";
	
	public void connect() throws UnknownHostException, IOException {
		_socket = new Socket(SERVER_IP, SERVER_PORT);
		_inputFromServer = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
		_outputToServer = new DataOutputStream(_socket.getOutputStream());
	}
	
	public void disconnect() throws IOException {
		_socket.close();
	}
	
	public void write(Message message) throws IOException {
		_outputToServer.writeBytes(message.getJsonString());
	}
	
	private void listen() throws IOException {
		String serverMessage = null;
		
		System.out.println("Listen from server...");
		serverMessage = _inputFromServer.readLine();
		
		if (serverMessage == null)
			throw new IOException("Server is offline!");
			
		System.out.println("Message from server: " + serverMessage + "\n");
		setChanged();
		notifyObservers(new Message(serverMessage));
	}
	
	@Override
	public void run() {
		boolean exit = false;
		while (!exit) {
			try {
				listen();
			} catch (IOException e) {
				e.printStackTrace();
				exit = true;
			}
		}
		notifyObservers(DISCONNECT_MESSAGE);
	}
}
