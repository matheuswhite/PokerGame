package core.handler.ret;

import java.util.List;

import core.domain.game.Room;
import core.handler.Handler;
import core.ui.graphic.screen.MainScreen;

public class GetRoomsRET extends Handler {

	@SuppressWarnings("unchecked")
	@Override
	public void handle(List<Object> content) {
		List<Room> rooms = (List<Room>) content.get(2);
		MainScreen mainScreen = (MainScreen) content.get(0);
		
		mainScreen.getRoomListManager().setRoomListItens(rooms);
	}

}
