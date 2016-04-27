package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.PlayerInfo;
import core.domain.Room;
import core.service.Range;
import core.ui.graphic.basics.Window;
import core.ui.graphic.graphicsManager.PlayersGraphicsManager;
import core.ui.graphic.graphicsManager.TableGraphicsManager;
import core.ui.input.Button;
import core.ui.input.Raise_BetInput;

public class MatchScreen extends Window {

	private Room _room;
	
	private PlayersGraphicsManager _playersGraphicsManager;
	private TableGraphicsManager _tableGraphicsManager;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Raise_BetInput _raise_betInput;
	private Button _leaveRoomButton;
	private Button _buyInButton;
	
	public MatchScreen(Room room) {
		super(850, 590, "PokerGame - Room" + room.getId());
		
		setBackgroundColor(Color.BLACK);
		
		_room = room;
		_playersGraphicsManager = new PlayersGraphicsManager(this);
		_tableGraphicsManager = new TableGraphicsManager(this);
		
		addRaise_BetButton();
		addFoldButton();
		addCheck_CallButton();
		addLeaveRoomButton();
		addBuyInButton();
	}
	
	public PlayersGraphicsManager getPlayerGraphicsManager() {
		return _playersGraphicsManager;
	}
	public TableGraphicsManager getTableGraphicsManager() {
		return _tableGraphicsManager;
	}
	
	private void addRaise_BetButton() {
		int min = _room.getMatchInfo().getSmallBlindValue().parseToInteger() * 4;
		int max = PlayerInfo.Instance().getMoneyPlayer().parseToInteger();
		
		_raise_betInput = new Raise_BetInput(new Point(310, 510), new Range(min, max), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_raise_betInput.getSlider());
		addComponent(_raise_betInput.getButton());
	}
	private void addCheck_CallButton() {
		_check_callButton = new Button(new Rectangle(570, 500, 130, 50), "Check", Color.BLUE, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_check_callButton);
	}
	private void addFoldButton() {
		_foldButton = new Button(new Rectangle(710, 500, 130, 50), "Fold", Color.BLUE, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_foldButton);
	}
	private void addLeaveRoomButton() {
		_leaveRoomButton = new Button(new Rectangle(750, 10, 90, 30), "Leave", Color.RED, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_leaveRoomButton);
	}
	private void addBuyInButton() {
		_buyInButton = new Button(new Rectangle(650, 10, 90, 30), "Buy In", Color.RED, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_buyInButton);
	}
}
