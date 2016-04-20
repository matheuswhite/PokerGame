package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.PlayerInfo;
import core.ui.graphic.basics.Window;
import core.ui.graphic.graphicsManager.PlayersGraphicsManager;
import core.ui.graphic.graphicsManager.TableGraphicsManager;
import core.ui.input.Button;
import core.ui.input.Raise_BetInput;

public class MatchScreen extends Window {

	private PlayersGraphicsManager _playersGraphicsManager;
	private TableGraphicsManager _tableGraphicsManager;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Raise_BetInput _raise_betInput;
	private Button _leaveRoomButton;
	private Button _buyInButton;
	
	public MatchScreen(long roomId, PlayerInfo player1) {
		super(850, 590, "PokerGame - Room" + roomId);
		
		setBackgroundColor(Color.BLACK);
		
		_playersGraphicsManager = new PlayersGraphicsManager(this, player1);
		_tableGraphicsManager = new TableGraphicsManager(this);
		
		addFoldButton();
		addCheck_CallButton();
		addRaise_BetButton();
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
		_raise_betInput = new Raise_BetInput(new Point(480, 500), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_raise_betInput.getButton());
		addComponent(_raise_betInput.getValue());
		addComponent(_raise_betInput.getPrefixMultiplierButton());
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
