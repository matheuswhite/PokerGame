package core.handler.handlerClient;

import java.util.List;

import core.domain.game.MatchInfo;
import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class EndTurnHandler extends Handler {

	private PlayerInfo _playerInfo;
	
	public EndTurnHandler(PlayerInfo playerInfo) {
		_playerInfo = playerInfo;
	}
	
	@Override
	public void handle(List<Object> content) {
		MatchInfo matchInfo = _gson.fromJson((String)content.get(2), MatchInfo.class);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getRoom().setMatchInfo(matchInfo);
			
			if (_playerInfo.getId() == matchInfo.getCurrentTurnPlayerId()) {
				matchScreen.myTurn();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
