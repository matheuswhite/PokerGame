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

import core.domain.action.ActionType;
import core.domain.action.EndTurnAction;
import core.domain.action.LeaveRoomAction;
import core.domain.action.UpdateMoneyAction;
import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.domain.game.PlayerStats;
import core.domain.game.Room;
import core.ui.graphic.BuyInPopUp;
import core.ui.graphic.MessagePopUp;
import core.ui.graphic.Timer;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.Window;
import core.ui.graphic.graphicsManager.PlayersGraphicsManager;
import core.ui.graphic.graphicsManager.TableGraphicsManager;
import core.ui.input.Button;
import core.ui.input.Raise_BetInput;

public class MatchScreen extends Window {
	
	private JFrame _matchWindow;
	private Room _room;
	private PlayerInfo _playerInfo;
	
	private PlayersGraphicsManager _playersGraphicsManager;
	private TableGraphicsManager _tableGraphicsManager;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Raise_BetInput _raise_betInput;
	private Button _leaveRoomButton;
	private Button _buyInButton;
	
	private Timer _timeToPlay;
	
	private EndTurnAction _endTurnAction;
	private LeaveRoomAction _leaveRoomAction;
	
	private UpdateMoneyAction _callAction;
	private UpdateMoneyAction _foldAction;
	private UpdateMoneyAction _betAction;
	
	public MatchScreen(JFrame mainWindow, Room room, PlayerInfo playerInfo) {
		super(850, 590, "PokerGame - Room" + room.getId());
		
		_matchWindow = this.getFrame();
		_room = room;
		_playerInfo = playerInfo;
		
		_leaveRoomAction = new LeaveRoomAction();
		_endTurnAction = new EndTurnAction(this);
		
		_callAction = new UpdateMoneyAction(ActionType.CALL);
		_foldAction = new UpdateMoneyAction(ActionType.FOLD);
		_betAction = new UpdateMoneyAction(ActionType.BET);
		
		setBackgroundColor(Color.BLACK);
		getFrame().addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				PlayerStats.Instance().getMoney().addMoney(playerInfo.getMoneyPlayer());
				mainWindow.setVisible(true);
				_leaveRoomAction.actionPerformed(null);
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
		
		_playersGraphicsManager = new PlayersGraphicsManager(this, room);
		_tableGraphicsManager = new TableGraphicsManager(this, room);
		
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
	
	public void endTurn() {
		_check_callButton.disable();
		_foldButton.disable();
		_raise_betInput.disable();
		_timeToPlay.stop();
	}
	public void myTurn() {
		_check_callButton.enable();
		_foldButton.enable();
		_raise_betInput.enable();
		_timeToPlay.start();
	}
	
	public void disableBuyIn() {
		_buyInButton.disable();
	}
	public void enableBuyIn() {
		_buyInButton.enable();
	}
	
	private void addTimeToPlay() {
		_timeToPlay = new Timer(this, new Point(50, 505), 30*1000, new TimerTask() {
			
			@Override
			public void run() {
				try {
					//_playersGraphicsManager.takeCards(PlayerInfo.Instance().getSeat());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				_foldAction.actionPerformed(null);
				_endTurnAction.actionPerformed(null);
			}
		});
	}
	
	private void addRaise_BetButton() {
		_raise_betInput = new Raise_BetInput(new Point(480, 500), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Money bet = new Money(_raise_betInput.getValue().getValue(), _raise_betInput.getPrefixMultiplierValue());
				
				if (bet.parseToLong() * 2 <= _room.getMatchInfo().getHigherCurrentBet().parseToLong()) {
					_betAction.setMoneyBet(bet);
					
					_playerInfo.getMoneyPlayer().removeMoney(bet);
					
					try {
						//_playersGraphicsManager.bet(PlayerInfo.Instance().getSeat(), bet);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					_betAction.actionPerformed(null);
					_endTurnAction.actionPerformed(null);
				}
				else {
					PopUp errorPopUp = new MessagePopUp(getFrame(), "Raise invalid!", "The raise must be double of higher bet");
					errorPopUp.setVisible(true);
				}
			}
		});
		
		_raise_betInput.disable();
		
		addComponent(_raise_betInput.getValue());
		addComponent(_raise_betInput.getButton());
		addComponent(_raise_betInput.getPrefixMultiplierButton());
	}
	private void addCheck_CallButton() {
		_check_callButton = new Button(new Rectangle(570, 500, 130, 50), "Check", Color.BLUE, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Money bet = _room.getMatchInfo().getHigherCurrentBet();
				
				if (bet != new Money()) {
					_callAction.setMoneyBet(bet);
					
					_playerInfo.getMoneyPlayer().removeMoney(bet);
					
					try {
						//_playersGraphicsManager.bet(PlayerInfo.Instance().getSeat(), bet);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		_check_callButton.addActionListener(_callAction);
		_check_callButton.addActionListener(_endTurnAction);
		_check_callButton.disable();
		
		addComponent(_check_callButton);
	}
	private void addFoldButton() {
		_foldButton = new Button(new Rectangle(710, 500, 130, 50), "Fold", Color.BLUE, Color.WHITE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//_playersGraphicsManager.takeCards(PlayerInfo.Instance().getSeat());
					enableBuyIn();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		_foldButton.addActionListener(_foldAction);
		_foldButton.addActionListener(_endTurnAction);
		_foldButton.disable();
		
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
				BuyInPopUp popUp = new BuyInPopUp(_matchWindow, "How much money you want?", _playerInfo);
				popUp.setVisible(true);
			}
		});
		
		disableBuyIn();
		addComponent(_buyInButton);
	}
}
