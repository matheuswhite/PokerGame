package core.handler.handlerClient;

import java.util.List;

import core.domain.game.Room;
import core.handler.Handler;
import core.net.ServerConnection;
import core.ui.graphic.screen.MainScreen;
import core.ui.graphic.screen.MatchScreen;

public class CreateRoomRET extends Handler {
	@Override
	public void handle(List<Object> content) {
		Room room = _gson.fromJson((String)content.get(2), Room.class);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		ServerConnection.Instance().getMessageHandler().setMatchScreen(new MatchScreen(mainScreen.getFrame(), room));
	}

}
