package core.ui.graphic;

import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Card;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Window;

public class TableCardsImages {

	private Image[] _cards;
	
	public TableCardsImages(Window window, Point location) {
		_cards = new Image[5];
		
		for (int i = 0; i < 5; i++) {
			_cards[i] = new Image(new Rectangle(location.x + (i * 65), location.y, 1280, 551), "src/imgs/cards.jpeg");
			_cards[i].hide();
			window.addComponent(_cards[i]);
		}
	}
	
	public void flipThreeCards(Card[] cards) {
		
		for (int i = 0; i < cards.length; i++) {
			_cards[i].crop(new Rectangle(98 * (cards[i].getNumber() - 1), 138 * (cards[i].getSuit().getValue()), 99, 137));
			_cards[i].resize(0.65, false);
			_cards[i].show();
		}
	}
	public void flipFourthCard(Card card) {
		_cards[3].crop(new Rectangle(98 * (card.getNumber() - 1), 138 * (card.getSuit().getValue()), 99, 137));
		_cards[3].resize(0.65, false);
		_cards[3].show();
	}
	public void flipFifthCard(Card card) {
		_cards[4].crop(new Rectangle(98 * (card.getNumber() - 1), 138 * (card.getSuit().getValue()), 99, 137));
		_cards[4].resize(0.65, false);
		_cards[4].show();
	}
	public void hidenAllCards() {
		for (int i = 0; i < _cards.length; i++) {
			_cards[i].hide();
		}
	}
}
