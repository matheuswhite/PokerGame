package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.handler.handlerServer.CreateRoomHandler;
import core.net.Message;
import core.net.ServerConnection;

public class CreateRoomAction extends Action {

	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		
		_msg = new Message(new CreateRoomHandler(), _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
