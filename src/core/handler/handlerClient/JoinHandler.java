package core.handler.handlerClient;

import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class JoinHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		PlayerInfo playerInfo = _gson.fromJson((String)content.get(2), PlayerInfo.class);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getPlayerGraphicsManager().addPlayer(playerInfo);
			matchScreen.getRoom().getPlayers().add(playerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
