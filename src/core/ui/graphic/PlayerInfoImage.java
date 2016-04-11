package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Money;

public class PlayerInfoImage {

	private Image _background;
	private Label _playerName;
	private Label _playerMoney;
	
	public PlayerInfoImage(Window window, Point point, String playerName, Money playerMoney) {
		_background = new Image(new Rectangle(point.x, point.y, 135, 40), "src/imgs/playerInfo");
		_playerName = new Label(new Point(point.x + 5, point.y - 5), playerName, new TextStyle(Color.WHITE, "Arial", 12, true, false));
		_playerMoney = new Label(new Point(point.x + 5, point.y + 15), "$" + playerMoney.toString(), new TextStyle(Color.WHITE, "Arial", 14, true, false));
		
		window.addComponent(_playerName);
		window.addComponent(_playerMoney);
		window.addComponent(_background);
	}
	
	public void setPlayerName(String playerName) {
		_playerName.setText(playerName);
	}
	
	public void setPlayerMoney(String playerMoney) {
		_playerMoney.setText(playerMoney);
	}
}
