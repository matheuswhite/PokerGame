package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.domain.game.Money;
import core.net.Message;
import core.net.ServerConnection;

public class CreateRoomAction extends Action {

	private Money _smallBlindValue;
	private Money _minBuyIn;
	
	public void setSmallBlindValue(Money smallBlindValue) {
		_smallBlindValue = smallBlindValue;
	}
	
	public void setMinimunBuyIn(Money minBuyIn) {
		_minBuyIn = minBuyIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_smallBlindValue);
		_content.add(_minBuyIn);
		
		_msg = new Message("CREATE_ROOM", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
