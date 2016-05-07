package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.handler.serverSideCopy.LeaveRoomHandler;
import core.net.Message;
import core.net.ServerConnection;

public class LeaveRoomAction extends Action {

	private long _roomId;
	
	public void setRoomId(long roomId) {
		_roomId = roomId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_roomId);
		
		_msg = new Message(new LeaveRoomHandler(), _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
