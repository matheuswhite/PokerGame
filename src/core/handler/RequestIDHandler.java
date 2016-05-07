package core.handler;

import java.util.List;

import core.domain.game.PlayerInfo;
import core.ui.graphic.screen.MainScreen;

public class RequestIDHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		long id = (long) content.get(2);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		PlayerInfo.Create(id);
		mainScreen.getServerIpPop().setVisible(false);
	}

}
