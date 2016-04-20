package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;
import core.service.Range;

public class GetRoomsAction extends ButtonAction {

	private Range _range;
	
	public GetRoomsAction() {
		super();
		_range = new Range(1,1);
	}
	
	public void setRange(Range range) {
		_range = range;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_range);
		
		_msg = new Message(1.0, "get_rooms", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
