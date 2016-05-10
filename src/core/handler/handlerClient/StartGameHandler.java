package core.handler.handlerClient;

import java.util.List;

import core.domain.game.MatchInfo;
import core.domain.game.PlayerInfo;
import core.domain.game.Room;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class StartGameHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		PlayerInfo playerInfo = (PlayerInfo) content.get(2);
		MatchInfo matchInfo = (MatchInfo) content.get(3);
		MatchScreen matchScreen = (MatchScreen) content.get(1);
		Room room = matchScreen.getRoom();
		
		try {
			matchScreen.getPlayerGraphicsManager().addPlayer(playerInfo);
			room.setMatchInfo(matchInfo);

			List<PlayerInfo> players = matchScreen.getRoom().getPlayers();
			for (int i = 0; i < players.size(); i++) {
				long id = players.get(i).getId();
				
				if (id == matchInfo.getBigBlindPlayerId()) {
					
				}
				if (id == matchInfo.getDealerPlayerId()) {
					
				}
				if (id == matchInfo.getSmallBlindPlayerId()) {
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
