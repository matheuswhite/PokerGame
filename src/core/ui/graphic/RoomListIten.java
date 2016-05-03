package core.ui.graphic;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.Money;
import core.domain.Room;
import core.ui.graphic.basics.Window;
import core.ui.input.Button;

public class RoomListIten extends Button {

	private Room _room;
	private EnterRoomPopUp _enterRoomPopUp;
	
	public RoomListIten(Window window, int posY) {
		super(new Rectangle(10, posY, 430, 30), "", new Color(93, 22, 255, 255), Color.WHITE, null);
	
		_room = new Room(404, new Money(), new Money());
		_enterRoomPopUp = new EnterRoomPopUp(window.getFrame(), "Do you enter in the Room00000000 ?");
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				_enterRoomPopUp.setVisible(true);
			}
		});
	}
	
	public void setInfos(Room room) {
		_room = room;
		_enterRoomPopUp.setRoom(_room);
		
		String text = "Room " + _room.getId() + repeat(" ", 20) + 
				_room.getPlayers().size() + "/6" + repeat(" ", 30) +
				_room.getMatchInfo().getSmallBlindValue().toString() + "/" +
				_room.getMatchInfo().getMinimumBuyIn().toString();	
		setText(text);
	}

	private String repeat(String value, int times) {
		return new String(new char[times]).replace("\0", value);
	}
}
