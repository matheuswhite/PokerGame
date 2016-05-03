package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import core.domain.PlayerInfo;
import core.ui.graphic.CreateRoomPopUp;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Window;
import core.ui.graphic.graphicsManager.PlayerStatsManager;
import core.ui.graphic.graphicsManager.RoomListManager;
import core.ui.input.Button;

public class MainScreen extends Window {

	private Window _windowInstance = this;
	
	private Image _logo;
	private PlayerStatsManager _playerStatsManager;
	private RoomListManager _roomListManager;
	
	private Button _createRoomButton;
	
	public MainScreen() {
		super(450, 700, "PokerGame - v1.0");
		
		createPlayerInfo();
		
		setBackgroundColor(new Color(0, 58, 98, 255));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_logo = new Image(new Rectangle(8, 15, 16, 16), "src/imgs/blueQuad");
		_logo.resize(new Dimension(240, 128), false);
		addComponent(_logo);
		
		addCreateRoomButton();
		
		_playerStatsManager = new PlayerStatsManager(this);
		_roomListManager = new RoomListManager(this);
		
		getFrame().addComponentListener(new ComponentAdapter() {
			
			public void componentShown(ComponentEvent e) {
				_playerStatsManager.updatePlayerStats();
			}
			
		});
	}

	private void createPlayerInfo() {
		//messageHandler 'requestId' must be create PlayerInfo
		PlayerInfo.Create(2413);
	}

	private void addCreateRoomButton() {
		_createRoomButton = new Button(new Rectangle(260, 150, 177, 30), "Create Room", new Color(93, 22, 255, 255), Color.WHITE, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateRoomPopUp popUp = new CreateRoomPopUp(_windowInstance.getFrame(), "Enter with the BuyIn and the SmallBlind value");
				popUp.setVisible(true);
			}
		});
		
		addComponent(_createRoomButton);
	}
	
	public PlayerStatsManager getPlayerStatsManager() {
		return _playerStatsManager;
	}
	
	public RoomListManager getRoomListManager() {
		return _roomListManager;
	}
}
