package core.ui.graphic.graphicsManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import core.domain.action.GetRoomsAction;
import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.domain.game.Room;
import core.service.PrefixMultiplier;
import core.service.Range;
import core.ui.graphic.RoomListIten;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Window;
import core.ui.input.Button;

public class RoomListManager {
	
	private Range _currentRange;
	private Button _prevButton;
	private Button _nextButton;
	private Button _refreshButton;
	private GetRoomsAction _prevButtonAction;
	private GetRoomsAction _nextButtonAction;
	private GetRoomsAction _refreshButtonAction;
	
	private Image _background1;
	private Image _background2;
	private List<RoomListIten> _roomsListItens;
	
	public RoomListManager(Window window, PlayerInfo playerInfo) {
		_background1 = new Image(new Rectangle(5, 150, 16, 16), "src/imgs/blueQuad");
		_background1.resize(new Dimension(245, 515), false);
		
		_background2 = new Image(new Rectangle(245, 190, 16, 16), "src/imgs/blueQuad");
		_background2.resize(new Dimension(200, 475), false);
		
		initRoomListItens(window, playerInfo);
		
		_currentRange = new Range(1, 13);
		
		_prevButtonAction = new GetRoomsAction();
		_prevButtonAction.setRange(new Range(_currentRange.getInitialIndex() - 20, _currentRange.getFinalIndex() - 20));
		
		_nextButtonAction = new GetRoomsAction();
		_nextButtonAction.setRange(new Range(_currentRange.getInitialIndex() + 20, _currentRange.getFinalIndex() + 20));
		
		_refreshButtonAction = new GetRoomsAction();
		_refreshButtonAction.setRange(_currentRange);
		
		_prevButton = new Button(new Rectangle(10, 155, 50, 30), "<", new Color(93, 22, 255, 255), Color.WHITE, new GetRoomsAction());
		_nextButton = new Button(new Rectangle(195, 155, 50, 30), ">", new Color(93, 22, 255, 255), Color.WHITE, new GetRoomsAction());
		_refreshButton = new Button(new Rectangle(65, 155, 125, 30), "Rooms", new Color(93, 22, 255, 255), Color.WHITE, new GetRoomsAction());
		
		window.addComponent(_prevButton);
		window.addComponent(_nextButton);
		window.addComponent(_refreshButton);
		window.addComponent(_background1);
		window.addComponent(_background2);
	}
	
	private void initRoomListItens(Window window, PlayerInfo playerInfo) {
		_roomsListItens = new ArrayList<RoomListIten>();
		
		/*
		_roomsListItens.add(new RoomListIten(window, 195));
		_roomsListItens.get(0).setInfos(new Room(1023, new Money(100, PrefixMultiplier.NONE), new Money(5, PrefixMultiplier.KILO)));
		window.addComponent(_roomsListItens.get(0));*/
		
		for (int i = 0; i < 13; i++) {
			_roomsListItens.add(new RoomListIten(window, 195 + (i * 35), playerInfo));
			_roomsListItens.get(i).disable();
			window.addComponent(_roomsListItens.get(i));
		}
	}
	
	public void setRoomListItens(List<Room> rooms) {
		for (int i = 0; i < 13; i++) {
			if (i < rooms.size()) {
				_roomsListItens.get(i).setInfos(rooms.get(i));
				_roomsListItens.get(i).enable();
			}
			else {
				_roomsListItens.get(i).setText("");
				_roomsListItens.get(i).disable();
			}
		}
	}
	
	public void setCurrentRange(Range currentRange) {
		_currentRange = currentRange;
	}
}
