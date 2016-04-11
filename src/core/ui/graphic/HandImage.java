package core.ui.graphic;

import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Card;

public class HandImage {

	private Image _card1;
	private Image _card2;
	private Image _hiddenCards;
	private boolean _hidden;
	
	public HandImage(Window window, Point location, Card card1, Card card2) {
		_card1 = new Image(new Rectangle(location.x, location.y, 1280, 551), "src/imgs/cards.jpeg");
		_card2 = new Image(new Rectangle(location.x + 25, location.y, 1280, 551), "src/imgs/cards.jpeg");
		_hiddenCards = new Image(new Rectangle(location.x, location.y, 90, 88), "src/imgs/hidenCards");
		
		_card1.crop(new Rectangle(99 * (card1.getNumber() - 1), 138 * (card1.getSuit().getValue()), 99, 137));
		_card2.crop(new Rectangle(99 * (card2.getNumber() - 1), 138 * (card2.getSuit().getValue()), 99, 137));
		
		_card1.resize(0.65, false);
		_card2.resize(0.65, false);
		_hiddenCards.resize(1, false);
		
		_card1.hide();
		_card2.hide();
		_hiddenCards.show();
		_hidden = true;
		
		window.addComponent(_card2);
		window.addComponent(_card1);
		window.addComponent(_hiddenCards);
	}
	
	public void flipCard() {
		if (_hidden) {
			_hiddenCards.hide();
			_card1.show();
			_card2.show();
		}
		else {
			_card1.hide();
			_card2.hide();
			_hiddenCards.show();
		}
		_hidden = !_hidden;
	}
	
	public void hide() {
		if (_hidden) {
			_hiddenCards.hide();
		}
		else {
			_card1.hide();
			_card2.hide();
		}
	}
	
	public void show() {
		if (_hidden) {
			_hiddenCards.show();
		}
		else {
			_card1.show();
			_card2.show();
		}
	}
}
