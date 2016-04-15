package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.Card;
import core.domain.Money;
import core.domain.PlayerInfo;
import core.domain.Suit;
import core.ui.graphic.BetTokenImage;
import core.ui.graphic.HandImage;
import core.ui.graphic.Image;
import core.ui.graphic.PlayersGraphicsManager;
import core.ui.graphic.PlayerInfoImage;
import core.ui.graphic.TableCardsImages;
import core.ui.graphic.Window;
import core.ui.input.Button;
import core.ui.input.Raise_BetInput;

public class MatchScreen extends Window {

	private PlayersGraphicsManager _playersGraphicsManager;
	private TableCardsImages _tableCardsImages;
	private Image _tableImage;
	private BetTokenImage _potValueImage;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Raise_BetInput _raise_betInput;
	private Button _leaveRoomButton;
	private Button _buyInButton;
	
	public MatchScreen(long roomId, PlayerInfo player1) {
		super(850, 590, "PokerGame - Room" + roomId);
		
		setBackgroundColor(Color.BLACK);
		
		_playersGraphicsManager = new PlayersGraphicsManager(this, player1);
		addPotValueImage();
		addTableCardsImages();		
		addTableImage();
		
		addFoldButton();
		addCheck_CallButton();
		addRaise_BetButton();
		addLeaveRoomButton();
		addBuyInButton();
	}
	
	private void addTableImage() {
		_tableImage = new Image(new Rectangle(40, 100, 904, 347), "src/imgs/tableImg");
		_tableImage.resize(new Dimension((int)(904 * 0.85), (int)(347 * 0.95)), false);
		
		addComponent(_tableImage);
	}
	
	
	
	private void addTableCardsImages() {
		Card[] cards = new Card[5];
		cards[0] = new Card(Suit.HEARTS, 1);
		cards[1] = new Card(Suit.SPADES, 1);
		cards[2] = new Card(Suit.CLUBS, 1);
		cards[3] = new Card(Suit.DIAMONDS, 1);
		cards[4] = new Card(Suit.HEARTS, 13);
		
		_tableCardsImages = new TableCardsImages(this, new Point(260, 210), cards);
	}
	
	private void addPotValueImage() {
		_potValueImage = new BetTokenImage(this, new Point(365, 310));
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
