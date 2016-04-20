package core.ui.graphic;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.Room;
import core.domain.actionListener.EnterRoomAction;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.Window;
import core.ui.input.Button;

public class RoomListIten extends Button {

	private Room _roomInfo;
	private PopUp _confirmPopUp;
	
	public RoomListIten(Window window, int posY, Room roomInfo) {
		super(new Rectangle(10, posY, 430, 30), "", new Color(93, 22, 255, 255), Color.WHITE, null);
	
		_roomInfo = roomInfo;
		_confirmPopUp = new PopUp(window.getFrame(), "", "You want to enter the room " + _roomInfo.getId() + "?", new EnterRoomAction(_roomInfo.getId())); 
		
		String text = "Room " + roomInfo.getId() + repeat(" ", 20) + 
			roomInfo.getPlayers().size() + "/6" + repeat(" ", 30) +
			roomInfo.getMatchInfo().getSmallBlindValue().toString() + "/" +
			roomInfo.getMatchInfo().getMinimumBuyIn().toString();
		
		setText(text);
		setActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				_confirmPopUp.setVisible(true);
			}
		});
	}

	private String repeat(String value, int times) {
		return new String(new char[times]).replace("\0", value);
	}
}
