package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import core.net.Message;
import core.net.ServerConnection;
import core.service.Range;

public class GetRoomsAction extends ButtonAction {

	public GetRoomsAction(ServerConnection connection) {
		super(connection);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content = new ArrayList<Object>();
		_content.add(new Range(1, 20));
		
		_msg = new Message(1.0, "get_rooms", _content);
		
		try {
			_connection.write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
