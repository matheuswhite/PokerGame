package core.handler.handlerClient;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.net.Message;
import core.ui.graphic.screen.MainScreen;

public class RequestID_RET extends Handler {

	private PlayerInfo _playerInfo;
	
	public RequestID_RET(PlayerInfo playerInfo) {
		_playerInfo = new PlayerInfo();
	}
	
	@Override
	public void handle(List<Object> content) {
		long id = _gson.fromJson((String)content.get(2), Long.class);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		_playerInfo.setId(id);
		
		List<Object> contents = new ArrayList<Object>();
		contents.add(_playerInfo);
		new Message("CREATE_PLAYER_INFO", contents);
		
		if (mainScreen == null)
			System.out.println("NULL");
		mainScreen.getServerIpPop().setVisible(false);
	}
}
