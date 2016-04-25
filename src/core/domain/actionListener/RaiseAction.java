package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;
import core.domain.Money;

public class RaiseAction extends ButtonAction {
	private Money _money;
	private ActionType _type;
	
	public RaiseAction(Money _money) {
		super();
		this._money = _money;
		this._type = ActionType.RAISE;
	}

	public void raise(Money money){
		_money=money;
	}
	
	public void actionPerformed(ActionEvent e) {
		_content.clear();
		_content.add(_money);
		_msg = new Message(1.0, _type.toString(), _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
