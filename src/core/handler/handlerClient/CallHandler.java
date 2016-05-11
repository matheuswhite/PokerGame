package core.handler.handlerClient;

import java.util.List;

import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class CallHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		PlayerInfo playerInfo = _gson.fromJson((String)content.get(2), PlayerInfo.class);
		Money money = _gson.fromJson((String)content.get(3), Money.class);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getPlayerGraphicsManager().bet(playerInfo.getSeat(), money);

			List<PlayerInfo> players = matchScreen.getRoom().getPlayers();
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getId() == playerInfo.getId()) {
					players.set(i, playerInfo);
					i = players.size() + 1;//break
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
