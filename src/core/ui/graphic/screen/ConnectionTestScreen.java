package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import core.domain.actionListener.EchoAction;
import core.domain.actionListener.GetRoomsAction;
import core.net.ServerConnection;
import core.ui.graphic.Label;
import core.ui.graphic.TextStyle;
import core.ui.graphic.Window;
import core.ui.input.Button;

public class ConnectionTestScreen extends Window {

	private Thread _connectionThread;
	private ServerConnection _connection;
	private Label _messageFromServer;
	private Label _lbl1;
	private Map<String, Button> _buttons;
	
	public ConnectionTestScreen() {
		super(400, 500, "Connection tests");
		
		_connection = new ServerConnection();
		try {
			_connection.connect();
			_connectionThread = new Thread(_connection);
			_connectionThread.start();
			
			initializeComponents();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Label l = new Label(new Point(50, 50), "Text Label!", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		Button b = new Button(new Rectangle(250, 250, 70, 30), "Go!", Color.RED, Color.WHITE, null);
		TextBox tb = new TextBox(new Rectangle(200, 50, 100, 25));
		NumberBox nb = new NumberBox(new Rectangle(300, 400, 50, 25), 0, 200);
		Image i = new Image(new Rectangle(450, 150, 1280, 551), "src/imgs/cards.jpeg");
		
		i.crop(new Rectangle(0, 0, 99, 138));
		//i.resize(0.6, false);
		
		w.addComponent(l);
		w.addComponent(b);
		w.addComponent(tb);
		w.addComponent(nb);
		w.addComponent(i);
	 */
	
	private void initializeButtons() {
		_buttons = new HashMap<String, Button>();
		_buttons.put("echo", new Button(new Rectangle(20, 310, 70, 30), "Echo", Color.YELLOW, Color.WHITE, new EchoAction(_connection)));
		_buttons.put("get_rooms", new Button(new Rectangle(100, 310, 110, 30), "Get Rooms", Color.YELLOW, Color.WHITE, new GetRoomsAction(_connection)));
		
		for (String button : _buttons.keySet()) {
			addComponent(_buttons.get(button));
		}
	}
	
	private void initializeLabels() {
		_lbl1 = new Label(new Point(20, 20), "Messages From Server", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		_messageFromServer = new Label(new Point(20, 50), "None", new TextStyle(Color.RED, "Arial", 12, false, false));
		
		addComponent(_lbl1);
		addComponent(_messageFromServer);
	}
	
	private void initializeComponents() {
		initializeLabels();
		initializeButtons();
	}
}
