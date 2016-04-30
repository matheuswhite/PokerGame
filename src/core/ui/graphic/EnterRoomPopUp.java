package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import core.domain.Room;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.TextStyle;
import core.ui.input.MoneyInput;

public class EnterRoomPopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 824213959521958735L;
	
	private Label _message;
	private MoneyInput _moneyInput;
	
	public EnterRoomPopUp(JFrame owner, String title) {
		super(owner, title);
		
		_message = new Label(new Point(0, 0), "Enter with the Buy In value", new TextStyle(Color.BLACK, "Arial", 12, true, true));
		_moneyInput = new MoneyInput(new Point(0, 20));
		
		addContent(_message.getComponent());
		addContent(_moneyInput.getComponent());
		
		setSize(260, 150);
		//addActionToConfirmButton(action);
	}
	
	public void setRoom(Room room) {
		setTitle("Do you enter in the Room" + room.getId() + " ?");
	}
}
