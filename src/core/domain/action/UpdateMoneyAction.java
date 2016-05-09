package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.domain.game.Money;
import core.net.Message;
import core.net.ServerConnection;

public class UpdateMoneyAction extends Action {

	private Money _moneyBet;
	private ActionType _type;
	
	public UpdateMoneyAction(ActionType type) {
		_type = type;
	}
	
	public void setMoneyBet(Money moneyBet) {
		_moneyBet = moneyBet;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_type);
		_content.add(_moneyBet);
		
		_msg = new Message("UPDATE_MONEY", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
