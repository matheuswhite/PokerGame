package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;

public class CheckCallAction extends ButtonAction {
	private ActionType _type;
	
	public CheckCallAction() {
		super();

		this._type = ActionType.CHECK;
	}

	public ActionType getType(){
		return _type;
	}
	
	public void changeType(){
		if(_type == ActionType.CHECK) _type = ActionType.CALL;
		else if(_type == ActionType.CALL) _type = ActionType.CHECK;
	}

	public void actionPerformed(ActionEvent e) {
		_content.clear();
		
		_msg = new Message(1.0, _type.toString(), _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
