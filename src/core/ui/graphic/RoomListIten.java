package core.ui.graphic;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.Money;
import core.domain.Room;
import core.domain.actionListener.EnterRoomAction;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.Window;
import core.ui.input.Button;

public class RoomListIten extends Button {

	private Room _roomInfo;
	private PopUp _confirmPopUp;
	private EnterRoomAction _enterRoomAction;
	
	public RoomListIten(Window window, int posY) {
		super(new Rectangle(10, posY, 430, 30), "", new Color(93, 22, 255, 255), Color.WHITE, null);
	
		_roomInfo = new Room(404, new Money(), new Money());
		_enterRoomAction = new EnterRoomAction();
		_confirmPopUp = new PopUp(window.getFrame(), "", "You want to enter the room 00000000 ?", _enterRoomAction); 
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				_confirmPopUp.setVisible(true);
			}
		});
	}
	
	public void setInfos(Room roomInfo) {
		_roomInfo = roomInfo;
		_enterRoomAction.setRoomId(_roomInfo.getId());
		String text = "Room " + _roomInfo.getId() + repeat(" ", 20) + 
				_roomInfo.getPlayers().size() + "/6" + repeat(" ", 30) +
				_roomInfo.getMatchInfo().getSmallBlindValue().toString() + "/" +
				_roomInfo.getMatchInfo().getMinimumBuyIn().toString();
			
		setText(text);
		_confirmPopUp.setMessage("You want to enter the room " + _roomInfo.getId() + " ?");
	}

	private String repeat(String value, int times) {
		return new String(new char[times]).replace("\0", value);
	}
}
