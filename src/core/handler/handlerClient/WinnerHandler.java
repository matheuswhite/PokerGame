package core.handler.handlerClient;

import java.util.List;

import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class WinnerHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		PlayerInfo playerInfo = _gson.fromJson((String)content.get(2), PlayerInfo.class);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		Money money = new Money(playerInfo.getMoneyPlayer().parseToLong());
		
		try {
			List<PlayerInfo> players = matchScreen.getRoom().getPlayers();
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getId() == playerInfo.getId()) {
					
					money.removeMoney(players.get(i).getMoneyPlayer());
					
					players.set(i, playerInfo);
					i = players.size() + 1; //break
				}
			}
			
			matchScreen.getPlayerGraphicsManager().addPlayerMoney(playerInfo.getSeat(), money);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
