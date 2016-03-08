package core.ui.graphic;

import java.awt.Point;

import javax.swing.JLabel;

public class Label {

	private JLabel _label;
	
	public Label(Point location, String text, TextStyle style) {
		_label = new JLabel(text);
		
		setLocation(location);
		changeTextStyle(style);
	}
	
	public void setLocation(Point point) {
		_label.setLocation(point);
	}
	
	public void setText(String text) {
		_label.setText(text);
	}
	
	public void changeTextStyle(TextStyle style) {
		style.setStyle(_label);
	}
}
