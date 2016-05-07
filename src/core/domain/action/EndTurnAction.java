package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.handler.serverSideCopy.EndTurnHandler;
import core.net.Message;
import core.net.ServerConnection;

public class EndTurnAction extends Action {

	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		
		_msg = new Message(new EndTurnHandler(), _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
