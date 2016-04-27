package core.ui.input;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import core.service.Range;
import core.ui.graphic.basics.Slider;
import core.ui.graphic.basics.TextStyle;

public class Raise_BetInput {

	private Button _raise_betButton;
	private Slider _raise_betSlider;
	
	public Raise_BetInput(Point point, Range range, ActionListener actionListener) {
		
		_raise_betSlider = new Slider(new Point(point.x, point.y), new Range(0, 100), new TextStyle(Color.WHITE, "Arial", 12, true, false));
		_raise_betButton = new Button(new Rectangle(point.x + 170, point.y - 10, 80, 50), "Raise", Color.BLUE, Color.WHITE, actionListener);
	}
	
	public Button getButton() {
		return _raise_betButton;
	}
	
	public Slider getSlider() {
		return _raise_betSlider;
	}
}
