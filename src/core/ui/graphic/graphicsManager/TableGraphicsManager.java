package core.ui.graphic.graphicsManager;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.game.Card;
import core.domain.game.Money;
import core.ui.graphic.BetTokenImage;
import core.ui.graphic.TableCardsImages;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Window;

public class TableGraphicsManager {
	
	private TableCardsImages _tableCardsImages;
	private Image _tableImage;
	private BetTokenImage _potValueImage;

	public TableGraphicsManager(Window window) {
		addPotValueImage(window);
		addTableCardsImages(window);		
		addTableImage(window);
	}
	
	public void addThreeCards(Card[] cards) {
		_tableCardsImages.flipThreeCards(cards);
	}
	public void addFourthCard(Card card) {
		_tableCardsImages.flipFourthCard(card);
	}
	public void addFifthCard(Card card) {
		_tableCardsImages.flipFifthCard(card);
	}
	public void clearCards() {
		_tableCardsImages.hidenAllCards();
	}
	
	
	public void addBetToPot(Money money) {
		_potValueImage.addMoney(money);
		_potValueImage.show();
	}
	public void clearPot() {
		_potValueImage.hide();
		_potValueImage.clearMoney();
	}
	
	
	private void addTableImage(Window window) {
		_tableImage = new Image(new Rectangle(40, 100, 904, 347), "src/imgs/tableImg");
		_tableImage.resize(new Dimension((int)(904 * 0.85), (int)(347 * 0.95)), false);
		
		window.addComponent(_tableImage);
	}
	private void addTableCardsImages(Window window) {
		_tableCardsImages = new TableCardsImages(window, new Point(260, 210));
	}
	private void addPotValueImage(Window window) {
		_potValueImage = new BetTokenImage(window, new Point(365, 310));
	}
}
