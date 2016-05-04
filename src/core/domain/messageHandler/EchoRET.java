package core.domain.messageHandler;

import java.util.Observable;

import core.net.Message;

public class EchoRET extends MessageHandler {
	
	@Override
	public void update(Observable o, Object arg) {
		_message = (Message) arg;
		if (!_message.getHandler().equals("ECHO_RET") || _message.getVersion() != 1.0) {
			return ;
		}
		
		System.out.println(_message.getContents().get(0));
	}
}
