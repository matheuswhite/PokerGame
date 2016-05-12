package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import core.domain.action.EchoAction;
import core.domain.action.GetRoomsAction;
import core.service.Range;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.TextStyle;
import core.ui.graphic.basics.Window;
import core.ui.input.Button;

public class ConnectionTestScreen extends Window {

	private Label _messageFromServer;
	private Label _lbl1;
	private Map<String, Button> _buttons;
	
	public ConnectionTestScreen() {
		super(400, 500, "Connection tests");

		initializeComponents();
	}
	
	private void initializeButtons() {
		_buttons = new HashMap<String, Button>();
		_buttons.put("echo", new Button(new Rectangle(20, 310, 70, 30), "Echo", Color.YELLOW, Color.WHITE, new EchoAction()));
		_buttons.put("get_rooms", new Button(new Rectangle(100, 310, 110, 30), "Get Rooms", Color.YELLOW, Color.WHITE, new GetRoomsAction(new Range())));
		
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
