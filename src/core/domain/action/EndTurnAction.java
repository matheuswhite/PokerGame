package core.domain.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import core.net.Message;
import core.net.ServerConnection;
import core.ui.graphic.screen.MatchScreen;

public class EndTurnAction extends Action {

	private MatchScreen _matchScreen;
	
	public EndTurnAction(MatchScreen matchScreen) {
		_matchScreen = matchScreen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_matchScreen.endTurn();
		
		_content.clear();
		
		_msg = new Message("ENT_TURN", _content);
		
		try {
			ServerConnection.Instance().write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
