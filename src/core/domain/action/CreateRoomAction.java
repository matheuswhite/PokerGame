package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.domain.game.Room;
import core.net.Message;
import core.net.ServerConnection;

public class CreateRoomAction extends Action {

	private Room _room;
	
	public void setRoom(Room room) {
		_room = room;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_room);
		
		_msg = new Message("CREATE_ROOM", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
