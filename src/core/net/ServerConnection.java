package core.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import core.domain.messageHandler.Handler;


public class ServerConnection extends Thread {
	
	private static ServerConnection _instance = null;
	
	private Socket _socket;
	private BufferedReader _inputFromServer;
	private DataOutputStream _outputToServer;
	
	private Message _message;
	private Handler _handler;
	
	public final static int SERVER_PORT = 1095;
	
	private ServerConnection() {
		
	}
	
	public static synchronized ServerConnection Instance() {
		if (_instance == null)
			_instance = new ServerConnection();
		return _instance;
	}
	
	public void connect(String serverIp) throws UnknownHostException, IOException, SocketTimeoutException {
		_socket = new Socket();
		_socket.connect(new InetSocketAddress(serverIp, SERVER_PORT), 2000);
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
			
		_message = new Message(serverMessage);
		_handler = _message.getHandler();
		_handler.handle(_message.getContents());
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
		createDisconnectMessage();
	}
	
	private void createDisconnectMessage() {
		Message message = new Message(1.0, "DISCONNECT_MESSAGE", null);
	}
}
