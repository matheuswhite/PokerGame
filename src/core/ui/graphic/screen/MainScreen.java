package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import core.domain.action.EchoAction;
import core.domain.game.PlayerStats;
import core.ui.graphic.CreateRoomPopUp;
import core.ui.graphic.ServerIpPopUp;
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
	private ServerIpPopUp _serverIpPopUp;
	
	public MainScreen() {
		super(450, 700, "PokerGame - v1.0");
		
		setBackgroundColor(new Color(0, 58, 98, 255));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				PlayerStats.Instance().save();
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
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
	
	public void initialize() {
		_serverIpPopUp = new ServerIpPopUp(this);
		_serverIpPopUp.setVisible(true);
		
		//test
		new EchoAction().actionPerformed(null);
		//end test
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
	
	public ServerIpPopUp getServerIpPop() {
		return _serverIpPopUp;
	}
	
	public PlayerStatsManager getPlayerStatsManager() {
		return _playerStatsManager;
	}
	
	public RoomListManager getRoomListManager() {
		return _roomListManager;
	}
}
