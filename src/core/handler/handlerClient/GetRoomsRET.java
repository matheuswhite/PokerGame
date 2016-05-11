package core.handler.handlerClient;

import java.util.List;

import core.domain.game.Room;
import core.handler.Handler;
import core.ui.graphic.screen.MainScreen;

public class GetRoomsRET extends Handler {
	
	@SuppressWarnings("unchecked")
	@Override
	public void handle(List<Object> content) {
		List<Room> rooms = _gson.fromJson((String)content.get(2), List.class);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		mainScreen.getRoomListManager().setRoomListItens(rooms);
	}

}
