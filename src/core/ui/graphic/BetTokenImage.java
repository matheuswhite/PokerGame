package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Money;

public class BetTokenImage {

	private Image _betTokenImage;
	private Label _betValue;
	
	public BetTokenImage(Window window, Point point) {
		
		_betTokenImage = new Image(new Rectangle(point.x, point.y, 31, 31), "src/imgs/betToken");
		_betValue = new Label(new Point(point.x + 35, point.y), "$" + "000", new TextStyle(Color.WHITE, "Arial", 14, true, false));
		
		_betTokenImage.hide();
		_betValue.hide();
		
		window.addComponent(_betTokenImage);
		window.addComponent(_betValue);
	}
	
	public void setMoney(Money money) {
		_betValue.setText("$" + money.toString());
	}
	
	public void hide() {
		_betTokenImage.hide();
		_betValue.hide();
	}
	
	public void show() {
		_betTokenImage.show();
		_betValue.show();
	}
}
