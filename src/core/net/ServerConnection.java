package core.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

import core.domain.game.PlayerInfo;

public class ServerConnection extends Thread {
	
	private static ServerConnection _instance = null;
	
	private Socket _socket;
	private BufferedReader _inputFromServer;
	private DataOutputStream _outputToServer;
	
	private MessageHandler _messageHandler;
	
	public final static int SERVER_PORT = 1095;
	
	private ServerConnection(PlayerInfo playerInfo) {
		_messageHandler = new MessageHandler(playerInfo);
	}
	
	public MessageHandler getMessageHandler() {
		return _messageHandler;
	}
	
	public static synchronized void Create(PlayerInfo playerInfo) {
		if (_instance == null)
			_instance = new ServerConnection(playerInfo);
	}
	
	public static synchronized ServerConnection Instance() {
		return _instance;
	}
	
	public void connect(String serverIp) throws UnknownHostException, IOException, SocketTimeoutException {
		_socket = new Socket();
		_socket.connect(new InetSocketAddress(serverIp, SERVER_PORT), 2000);
		_inputFromServer = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
		_outputToServer = new DataOutputStream(_socket.getOutputStream());
		
		write(new Message("REQUEST_ID", new ArrayList<Object>()));
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
			
		_messageHandler.handler(new Message(serverMessage));
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
		_messageHandler.handler(new Message("DISCONNECT", new ArrayList<Object>()));
	}
}
