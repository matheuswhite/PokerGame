package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.domain.messageHandler.EchoHandler;
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
		
		_msg = new Message(new EchoHandler(), _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(_content.get(0));
	}
}
