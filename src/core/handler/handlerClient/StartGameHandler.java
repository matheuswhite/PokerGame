package core.handler.handlerClient;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.MatchInfo;
import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class StartGameHandler extends Handler {

	private PlayerInfo _playerInfo;
	
	public StartGameHandler(PlayerInfo playerInfo) {
		_playerInfo = playerInfo;
	}
	
	@Override
	public void handle(List<Object> content) {
		int size = _gson.fromJson((String)content.get(2), Integer.class);
		List<PlayerInfo> playerInfos = new ArrayList<PlayerInfo>();
		for (int i = 0; i < size; i++) {
			playerInfos.add(_gson.fromJson((String)content.get(2), PlayerInfo.class));
		}
		MatchInfo matchInfo = _gson.fromJson((String)content.get(3 + size), MatchInfo.class);
		
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		
		try {
			matchScreen.getRoom().setMatchInfo(matchInfo);
			matchScreen.getRoom().getPlayers().clear();
			matchScreen.getRoom().getPlayers().addAll(playerInfos);

			matchScreen.getTableGraphicsManager().clearCards();
			matchScreen.getTableGraphicsManager().clearPot();
			
			for (PlayerInfo playerInfo : playerInfos) {
				Money bet = playerInfo.getMoneyBetting();

				if (!bet.equals(new Money())) {
					matchScreen.getPlayerGraphicsManager().bet(playerInfo.getSeat(), bet);
				}
				if (playerInfo.getId() == matchInfo.getDealerPlayerId()) {
					matchScreen.getPlayerGraphicsManager().setDealer(playerInfo.getSeat());
				}
				
				matchScreen.getPlayerGraphicsManager().giveCards(playerInfo.getSeat(), 
						playerInfo.getHand()[0], playerInfo.getHand()[1]);
				
				if (_playerInfo.getId() == playerInfo.getId()) {
					matchScreen.getPlayerGraphicsManager().showCards(playerInfo.getSeat());
					matchScreen.disableBuyIn();
					
					if (playerInfo.getId() == matchInfo.getCurrentTurnPlayerId())
						matchScreen.myTurn();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
