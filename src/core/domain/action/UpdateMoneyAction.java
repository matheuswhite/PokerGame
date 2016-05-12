package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.net.Message;
import core.net.ServerConnection;

public class UpdateMoneyAction extends Action {

	private PlayerInfo _playerInfo;
	private Money _moneyBet;
	private ActionType _type;
	
	public UpdateMoneyAction(PlayerInfo playerInfo) {
		_playerInfo = playerInfo;
	}
	
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
		if (_type != ActionType.FOLD) {
			_content.add(_moneyBet);
			_playerInfo.setMoneyBetting(_moneyBet);
		}
		
		_msg = new Message("UPDATE_MONEY", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
