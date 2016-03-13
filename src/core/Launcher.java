package core;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.ui.graphic.Image;
import core.ui.graphic.Label;
import core.ui.graphic.TextStyle;
import core.ui.graphic.Window;
import core.ui.input.Button;
import core.ui.input.NumberBox;
import core.ui.input.TextBox;

public class Launcher {
	
	public static void main(String[] args) {
		Window w = new Window(700, 500, "PokerGame");
		Label l = new Label(new Point(50, 50), "Text Label!", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		Button b = new Button(new Rectangle(250, 250, 70, 30), "Go!", Color.RED, Color.WHITE, null);
		TextBox tb = new TextBox(new Rectangle(200, 50, 100, 25));
		NumberBox nb = new NumberBox(new Rectangle(300, 400, 50, 25), 0, 200);
		Image i = new Image(new Rectangle(450, 150, 1280, 551), "src/imgs/cards.jpeg");
		
		i.crop(new Rectangle(0, 0, 99, 138));
		//i.resize(0.6, false);
		
		w.addComponent(l);
		w.addComponent(b);
		w.addComponent(tb);
		w.addComponent(nb);
		w.addComponent(i);
	}
}
