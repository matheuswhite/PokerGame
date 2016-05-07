package core.handler.ret;

import java.util.List;

import core.domain.game.Room;
import core.handler.Handler;
import core.net.ServerConnection;
import core.ui.graphic.screen.MainScreen;
import core.ui.graphic.screen.MatchScreen;

public class CreateRoomRET extends Handler {

	@Override
	public void handle(List<Object> content) {
		Room room = (Room) content.get(2);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		ServerConnection.Instance().getMessageHandler().setMatchScreen(new MatchScreen(mainScreen.getFrame(), room));
	}

}
