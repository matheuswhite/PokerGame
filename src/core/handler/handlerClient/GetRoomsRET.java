package core.handler.handlerClient;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.Room;
import core.handler.Handler;
import core.ui.graphic.screen.MainScreen;

public class GetRoomsRET extends Handler {
	
	@Override
	public void handle(List<Object> content) {
		int size = _gson.fromJson((String)content.get(2), Integer.class);
		List<Room> rooms = new ArrayList<Room>();
		
		for (int i = 1; i <= size; i++) {
			_gson.fromJson((String)content.get(2+i), List.class);
		}
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		mainScreen.getRoomListManager().setRoomListItens(rooms);
	}

}
