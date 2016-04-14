package core.ui.graphic;

import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Card;

public class TableCardsImages {

	private Image[] _cards;
	
	public TableCardsImages(Window window, Point location, Card[] cards) {
		_cards = new Image[5];
		
		for (int i = 0; i < cards.length; i++) {
			_cards[i] = new Image(new Rectangle(location.x + (i * 65), location.y, 1280, 551), "src/imgs/cards.jpeg");
			_cards[i].crop(new Rectangle(98 * (cards[i].getNumber() - 1), 138 * (cards[i].getSuit().getValue()), 99, 137));
			_cards[i].resize(0.65, false);
			_cards[i].hide();
			window.addComponent(_cards[i]);
		}
	}
	
	public void flipThreeCards() {
		_cards[0].show();
		_cards[1].show();
		_cards[2].show();
	}
	
	public void flipFourthCard() {
		_cards[3].show();
	}
	
	public void flipFifthCard() {
		_cards[4].show();
	}
	
	public void hidenAllCards() {
		for (int i = 0; i < _cards.length; i++) {
			_cards[i].hide();
		}
	}
}
