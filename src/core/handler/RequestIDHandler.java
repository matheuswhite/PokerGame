package core.handler;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.serverSideCopy.CreatePlayerInfo;
import core.net.Message;
import core.ui.graphic.screen.MainScreen;

public class RequestIDHandler extends Handler {

	@Override
	public void handle(List<Object> content) {
		long id = (long) content.get(2);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		PlayerInfo.Create(id);
		
		List<Object> contents = new ArrayList<Object>();
		contents.add(PlayerInfo.Instance());
		new Message(new CreatePlayerInfo(), contents);
		
		mainScreen.getServerIpPop().setVisible(false);
	}

}
