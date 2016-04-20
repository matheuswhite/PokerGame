package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Money;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.TextStyle;
import core.ui.graphic.basics.Window;

public class BetTokenImage {

	private Image _betTokenImage;
	private Label _betValue;
	
	private Money _money;
	
	public BetTokenImage(Window window, Point point) {
		_money = new Money();
		
		_betTokenImage = new Image(new Rectangle(point.x, point.y, 31, 31), "src/imgs/betToken");
		_betValue = new Label(new Point(point.x + 35, point.y), "$" + "000", new TextStyle(Color.WHITE, "Arial", 14, true, false));
		
		_betTokenImage.hide();
		_betValue.hide();
		
		window.addComponent(_betTokenImage);
		window.addComponent(_betValue);
	}
	
	public void addMoney(Money money) {
		_money.addMoney(money);
		_betValue.setText("$" + money.toString());
	}
	
	public void clearMoney() {
		_money = new Money();
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
