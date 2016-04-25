package core.ui.graphic.graphicsManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import core.domain.Money;
import core.service.PrefixMultiplier;
import core.ui.graphic.basics.Image;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.TextStyle;
import core.ui.graphic.basics.Window;

public class PlayerStatsManager {
	
	private Label _name;
	private Label _money;
	private Label _wins;
	private Label _losses;
	private Image _background;
	
	public PlayerStatsManager(Window window) {
		_background = new Image(new Rectangle(255, 15, 16, 16), "src/imgs/lightBlueQuad");
		_background.resize(new Dimension(187, 170), false);
		
		int size = 14;
		_name = new Label(new Point(260, 15), "Name: Matheus San", new TextStyle(Color.WHITE, "Arial", size, true, false));
		_money = new Label(new Point(260, 35), "Money: " + new Money(999, PrefixMultiplier.MEGA).toString(), new TextStyle(Color.WHITE, "Arial", size, true, false));
		_wins = new Label(new Point(260, 55), "Wins:    83", new TextStyle(Color.WHITE, "Arial", size, true, false));
		_losses = new Label(new Point(260, 75), "Losses: 14", new TextStyle(Color.WHITE, "Arial", size, true, false));
		
		window.addComponent(_name);
		window.addComponent(_money);
		window.addComponent(_wins);
		window.addComponent(_losses);
		window.addComponent(_background);
	}
}
