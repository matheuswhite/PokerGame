package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.org.apache.regexp.internal.recompile;

import core.domain.Card;
import core.domain.Money;
import core.domain.Suit;
import core.service.PrefixMultiplier;
import core.ui.graphic.BetTokenImage;
import core.ui.graphic.HandImage;
import core.ui.graphic.Image;
import core.ui.graphic.PlayerInfoImage;
import core.ui.graphic.TableCardsImages;
import core.ui.graphic.Window;
import core.ui.input.Button;
import core.ui.input.Raise_BetInput;

public class MatchScreen extends Window {

	private Image[] _emptySeatsImages;
	private HandImage[] _handsImages;
	private PlayerInfoImage[] _infoImages;
	private BetTokenImage[] _betTokenImages;
	private Image[] _dealerImages;
	private TableCardsImages _tableCardsImages;
	private Image _tableImage;
	private BetTokenImage _potValueImage;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Raise_BetInput _raise_betInput;
	private Button _leaveRoomButton;
	private Button _buyInButton;
	
	public MatchScreen() {
		super(850, 590, "PokerGame - Match");
		
		setBackgroundColor(Color.BLACK);
		
		addDealerImages();
		addPlayerInfoImages();
		addHandImages();
		addEmptySeatImages();
		addPotValueImage();
		addTableCardsImages();
		addBetTokenImages();		
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
	
	private void addEmptySeatImages() {
		_emptySeatsImages = new Image[6];
		
		_emptySeatsImages[0] = new Image(new Rectangle(750, 210, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[1] = new Image(new Rectangle(530, 370, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[2] = new Image(new Rectangle(220, 370, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[3] = new Image(new Rectangle(10, 210, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[4] = new Image(new Rectangle(220, 60, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[5] = new Image(new Rectangle(530, 60, 117, 117), "src/imgs/emptySeat");
		
		for (int i = 0; i < _emptySeatsImages.length; i++) {
			_emptySeatsImages[i].resize(0.8, false);
			_emptySeatsImages[i].hide();
			addComponent(_emptySeatsImages[i]);
		}
	}
	
	private void addHandImages() {
		_handsImages = new HandImage[6];
		
		_handsImages[0] = new HandImage(this, new Point(720, 195), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		_handsImages[1] = new HandImage(this, new Point(540, 365), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		_handsImages[2] = new HandImage(this, new Point(200, 365), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		_handsImages[3] = new HandImage(this, new Point(20, 195), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		_handsImages[4] = new HandImage(this, new Point(230, 45), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		_handsImages[5] = new HandImage(this, new Point(520, 45), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		
		Button _testButton = new Button(new Rectangle(0, 0, 70, 30), "Flip", Color.YELLOW, Color.WHITE, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_handsImages[0].flipCard();
			}
		});
		addComponent(_testButton);
	}
	
	private void addPlayerInfoImages() {
		_infoImages = new PlayerInfoImage[6];
		
		_infoImages[0] = new PlayerInfoImage(this, new Point(710, 265), "player1", new Money(982, PrefixMultiplier.NONE));
		_infoImages[1] = new PlayerInfoImage(this, new Point(530, 435), "player2", new Money(182, PrefixMultiplier.KILO));
		_infoImages[2] = new PlayerInfoImage(this, new Point(190, 435), "player3", new Money(284, PrefixMultiplier.MEGA));
		_infoImages[3] = new PlayerInfoImage(this, new Point(10, 265), "player4", new Money(159, PrefixMultiplier.GIGA));
		_infoImages[4] = new PlayerInfoImage(this, new Point(220, 115), "player5", new Money(187, PrefixMultiplier.KILO));
		_infoImages[5] = new PlayerInfoImage(this, new Point(510, 115), "player6", new Money(12, PrefixMultiplier.TERA));
	}
	
	private void addBetTokenImages() {
		_betTokenImages = new BetTokenImage[6];

		_betTokenImages[0] = new BetTokenImage(this, new Point(605, 220), new Money(100, PrefixMultiplier.KILO));
		_betTokenImages[1] = new BetTokenImage(this, new Point(550, 325), new Money(50, PrefixMultiplier.KILO));
		_betTokenImages[2] = new BetTokenImage(this, new Point(210, 325), new Money(100, PrefixMultiplier.KILO));
		_betTokenImages[3] = new BetTokenImage(this, new Point(130, 220), new Money(100, PrefixMultiplier.KILO));
		_betTokenImages[4] = new BetTokenImage(this, new Point(230, 165), new Money(100, PrefixMultiplier.KILO));
		_betTokenImages[5] = new BetTokenImage(this, new Point(520, 165), new Money(100, PrefixMultiplier.KILO));
	}
	
	private void addDealerImages() {
		int width = 34;
		int height = 28;
		String filePath = "src/imgs/dealerToken";
		
		_dealerImages = new Image[6];
		
		_dealerImages[0] = new Image(new Rectangle(800, 270, width, height), filePath);
		_dealerImages[1] = new Image(new Rectangle(640, 440, width, height), filePath);
		_dealerImages[2] = new Image(new Rectangle(280, 440, width, height), filePath);
		_dealerImages[3] = new Image(new Rectangle(100, 270, width, height), filePath);
		_dealerImages[4] = new Image(new Rectangle(310, 120, width, height), filePath);
		_dealerImages[5] = new Image(new Rectangle(600, 120, width, height), filePath);
		
		for (int i = 0; i < _dealerImages.length; i++) {
			if (i!=0) 
				_dealerImages[i].hide();
			addComponent(_dealerImages[i]);
		}
	}
	
	private void addTableCardsImages() {
		
	}
	
	private void addPotValueImage() {
		_potValueImage = new BetTokenImage(this, new Point(365, 310), new Money(236, PrefixMultiplier.MEGA));
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
