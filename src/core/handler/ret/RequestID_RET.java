package core.handler.ret;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.net.Message;
import core.ui.graphic.screen.MainScreen;

public class RequestID_RET extends Handler {

	@Override
	public void handle(List<Object> content) {
		long id = (long) content.get(2);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		PlayerInfo.Create(id);
		
		List<Object> contents = new ArrayList<Object>();
		contents.add(PlayerInfo.Instance());
		new Message("CREATE_PLAYER_INFO", contents);
		
		mainScreen.getServerIpPop().setVisible(false);
	}
}
