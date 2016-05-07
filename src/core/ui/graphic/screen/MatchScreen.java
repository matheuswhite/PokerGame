package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.TimerTask;

import javax.swing.JFrame;

import core.domain.game.PlayerInfo;
import core.domain.game.PlayerStats;
import core.domain.game.Room;
import core.ui.graphic.BuyInPopUp;
import core.ui.graphic.Timer;
import core.ui.graphic.basics.Window;
import core.ui.graphic.graphicsManager.PlayersGraphicsManager;
import core.ui.graphic.graphicsManager.TableGraphicsManager;
import core.ui.input.Button;
import core.ui.input.Raise_BetInput;

public class MatchScreen extends Window {
	
	private JFrame _matchWindow;
	private Room _room;
	
	private PlayersGraphicsManager _playersGraphicsManager;
	private TableGraphicsManager _tableGraphicsManager;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Raise_BetInput _raise_betInput;
	private Button _leaveRoomButton;
	private Button _buyInButton;
	
	private Timer _timeToPlay;
	
	public MatchScreen(JFrame mainWindow, Room room) {
		super(850, 590, "PokerGame - Room" + room.getId());
		
		_matchWindow = this.getFrame();
		_room = room;
		
		setBackgroundColor(Color.BLACK);
		getFrame().addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				PlayerStats.Instance().getMoney().addMoney(PlayerInfo.Instance().getMoneyPlayer());
				mainWindow.setVisible(true);
				//send message 'leaveRoom'
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				_matchWindow.dispose();
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
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		_playersGraphicsManager = new PlayersGraphicsManager(this);
		_tableGraphicsManager = new TableGraphicsManager(this);
		
		addRaise_BetButton();
		addFoldButton();
		addCheck_CallButton();
		addLeaveRoomButton();
		addBuyInButton();
		
		addTimeToPlay();
	}

	public PlayersGraphicsManager getPlayerGraphicsManager() {
		return _playersGraphicsManager;
	}
	public TableGraphicsManager getTableGraphicsManager() {
		return _tableGraphicsManager;
	}
	
	public Room getRoom() {
		return _room;
	}
	
	private void addTimeToPlay() {
		_timeToPlay = new Timer(this, new Point(50, 505), 30*1000, new TimerTask() {
			
			@Override
			public void run() {
				_timeToPlay.stop();
			}
		});
	}
	
	private void addRaise_BetButton() {
		_raise_betInput = new Raise_BetInput(new Point(480, 500), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addComponent(_raise_betInput.getValue());
		addComponent(_raise_betInput.getButton());
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
				_matchWindow.dispose();
			}
		});
		
		addComponent(_leaveRoomButton);
	}
	private void addBuyInButton() {
		_buyInButton = new Button(new Rectangle(650, 10, 90, 30), "Buy In", Color.RED, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuyInPopUp popUp = new BuyInPopUp(_matchWindow, "How much money you want?");
				popUp.setVisible(true);
			}
		});
		
		addComponent(_buyInButton);
	}
}
