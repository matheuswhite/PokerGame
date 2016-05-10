package core.handler.handlerClient;

import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class FoldHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		PlayerInfo playerInfo = (PlayerInfo) content.get(2);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getPlayerGraphicsManager().takeCards(playerInfo.getSeat());

			List<PlayerInfo> players = matchScreen.getRoom().getPlayers();
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getId() == playerInfo.getId()) {
					players.remove(i);
					players.add(i, playerInfo);
					i = players.size() + 1;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
