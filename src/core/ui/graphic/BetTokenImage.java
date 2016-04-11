package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Money;

public class BetTokenImage {

	private Image _betTokenImage;
	private Label _betValue;
	
	public BetTokenImage(Window window, Point point, Money betValue) {
		
		_betTokenImage = new Image(new Rectangle(point.x, point.y, 31, 31), "src/imgs/betToken");
		_betValue = new Label(new Point(point.x + 35, point.y), "$" + betValue.toString(), new TextStyle(Color.WHITE, "Arial", 14, true, false));
		
		window.addComponent(_betTokenImage);
		window.addComponent(_betValue);
	}
}
