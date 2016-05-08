package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.game.PlayerInfo;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.TextStyle;
import core.ui.graphic.basics.Window;

public class PlayerInfoImage {

	private Image _background;
	private Label _playerName;
	private Label _playerMoney;
	
	public PlayerInfoImage(Window window, Point point) {
		_background = new Image(new Rectangle(point.x, point.y, 135, 40), "src/imgs/playerInfo");
		_playerName = new Label(new Point(point.x + 5, point.y - 5), "none", new TextStyle(Color.WHITE, "Arial", 12, true, false));
		_playerMoney = new Label(new Point(point.x + 5, point.y + 15), "$" + "000", new TextStyle(Color.WHITE, "Arial", 14, true, false));
		
		_background.hide();
		_playerName.hide();
		_playerMoney.hide();
		
		window.addComponent(_playerName);
		window.addComponent(_playerMoney);
		window.addComponent(_background);
	}
	
	public void hide() {
		_background.hide();
		_playerName.hide();
		_playerMoney.hide();
	}
	
	public void show() {
		_background.show();
		_playerName.show();
		_playerMoney.show();
	}

	public void setInfos(PlayerInfo player) {
		_playerName.setText(player.getName());
		_playerMoney.setText("$" + player.getMoneyPlayer().toString());
	}
}
