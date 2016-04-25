package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;

public class FoldAction extends ButtonAction {
	private ActionType _type;
	
	public FoldAction(){
		super();
		_type = ActionType.FOLD;
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
