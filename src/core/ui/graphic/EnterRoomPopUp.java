package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import core.domain.PlayerStats;
import core.domain.Room;
import core.service.Range;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.Slider;
import core.ui.graphic.basics.TextStyle;

public class EnterRoomPopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 824213959521958735L;
	
	private Label _message;
	private Slider _slider;
	
	public EnterRoomPopUp(JFrame owner, String title) {
		super(owner, title);
		
		_message = new Label(new Point(0, 0), "Enter with the Buy In value", new TextStyle(Color.BLACK, "Arial", 12, true, true));
		_slider = new Slider(new Point(0, 0), new Range(0, 999), new TextStyle(Color.BLACK, "Arial", 12, true, false));
		
		addContent(_message.getComponent());
		addContent(_slider.getComponent());
		
		setSize(350, 110);
		//addActionToConfirmButton(action);
	}
	
	public void setRoom(Room room) {
		setTitle("Do you enter in the Room" + room.getId() + " ?");
		
		int min = room.getMatchInfo().getMinimumBuyIn().parseToInteger();
		int max = PlayerStats.Instance().getMoney().parseToInteger();
		_slider.setRange(new Range(min, max));
	}
}
