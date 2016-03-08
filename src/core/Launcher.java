package core;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.ui.graphic.Label;
import core.ui.graphic.TextStyle;
import core.ui.graphic.Window;
import core.ui.input.Button;

public class Launcher {
	
	public static void main(String[] args) {
		Window w = new Window(700, 500, "PokerGame");
		Label l = new Label(new Point(50, 50), "Text Label!", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		Button b = new Button(new Rectangle(250, 250, 70, 30), "Go!", Color.RED, Color.WHITE, null);
		
		w.addComponent(l);
		w.addComponent(b);
	}
}
