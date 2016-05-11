package core.handler.handlerClient;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.net.Message;
import core.ui.graphic.screen.MainScreen;

public class RequestID_RET extends Handler {

	@Override
	public void handle(List<Object> content) {
		double id = _gson.fromJson((String)content.get(2), Double.class);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		PlayerInfo.Create((long)id);
		
		List<Object> contents = new ArrayList<Object>();
		contents.add(PlayerInfo.Instance());
		new Message("CREATE_PLAYER_INFO", contents);
		
		if (mainScreen == null)
			System.out.println("NULL");
		mainScreen.getServerIpPop().setVisible(false);
	}
}
