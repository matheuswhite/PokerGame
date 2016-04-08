package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;

public class EnterRoomAction extends ButtonAction {

	private long _roomId;
	private long _myId;
	
	public EnterRoomAction(ServerConnection connection, long roomId, long myId) {
		super(connection);
		_roomId = roomId;
		_myId = myId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_roomId);
		_content.add(_myId);
		
		_msg = new Message(1.0, "enter_room", _content);
		
		try {
			_connection.write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
