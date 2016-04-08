package core.ui.graphic.screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.domain.Card;
import core.domain.Suit;
import core.ui.graphic.BetTokenImage;
import core.ui.graphic.DealerImage;
import core.ui.graphic.EmptySeatImage;
import core.ui.graphic.HandImage;
import core.ui.graphic.PlayerInfoImage;
import core.ui.graphic.PotValue;
import core.ui.graphic.TableImage;
import core.ui.graphic.Window;
import core.ui.input.Button;

public class MatchScreen extends Window {

	private EmptySeatImage[] _emptySeats;
	private HandImage[] _handsImages;
	private PlayerInfoImage[] _infoImages;
	private BetTokenImage[] _betTokenImages;
	private DealerImage _dealerImage;
	private TableImage _tableImage;
	private PotValue _potValue;
	
	private Button _check_callButton;
	private Button _foldButton;
	private Button _raise_betButton;
	private Button _leaveRoom;
	private Button _buyInButton;
	private Button _testButton;
	
	public MatchScreen() {
		super(700, 400, "PokerGame - Match");
		
		setBackgroundColor(Color.BLACK);
		
		_handsImages = new HandImage[6];
		_handsImages[0] = new HandImage(new Point(500, 200), new Card(Suit.HEARTS, 4), new Card(Suit.CLUBS, 1));
		
		_testButton = new Button(new Rectangle(0, 0, 70, 30), "Flip", Color.YELLOW, Color.WHITE, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_handsImages[0].flipCard();
			}
		});
		
		addComponent(_handsImages[0].getCard2());
		addComponent(_handsImages[0].getCard1());
		addComponent(_handsImages[0].getHiddenCards());
		addComponent(_testButton);
	}

}
