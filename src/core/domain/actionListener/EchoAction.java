package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;

public class EchoAction extends ButtonAction {
	
	public EchoAction() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		_content.clear();
		_content.add("Can you hear me server?");
		
		_msg = new Message(1.0, "echo", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
