package core.handler.handlerClient;

import java.util.List;

import core.domain.game.MatchInfo;
import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class EndTurnHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		MatchInfo matchInfo = (MatchInfo) content.get(2);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getRoom().setMatchInfo(matchInfo);
			
			if (PlayerInfo.Instance().getId() == matchInfo.getCurrentTurnPlayerId()) {
				matchScreen.myTurn();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
