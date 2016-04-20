package core.ui.graphic.graphicsManager;

import core.domain.Money;
import core.domain.Room;
import core.domain.actionListener.EnterRoomAction;
import core.service.PrefixMultiplier;
import core.ui.graphic.RoomListIten;
import core.ui.graphic.basics.Window;

public class RoomListManager {

	public RoomListManager(Window window) {
		
		Room roomInfo = new Room(2314, new Money(100, PrefixMultiplier.NONE), new Money(10, PrefixMultiplier.NONE));
		window.addComponent(new RoomListIten(window, 200, roomInfo));
	}
}
