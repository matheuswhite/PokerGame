package core.handler.handlerClient;

import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class LeaveHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		PlayerInfo playerInfo = _gson.fromJson((String)content.get(2), PlayerInfo.class);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getPlayerGraphicsManager().removePlayer(playerInfo.getSeat());
			
			List<PlayerInfo> players = matchScreen.getRoom().getPlayers();
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getId() == playerInfo.getId()) {
					players.remove(i);
					i = players.size() + 1;//break
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
