package core.ui.graphic;

import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JLabel;

import core.ui.UI_Element;

public class Label implements UI_Element {
	
	private JLabel _label;
	
	public Label(Point location, String text, TextStyle style) {
		_label = new JLabel();
		
		setLocation(location);
		setText(text);
		changeTextStyle(style);
	}
	
	public void setLocation(Point point) {
		_label.setLocation(point);
	}
	
	public void setText(String text) {
		_label.setText(text);
		_label.setSize(text.length() * 10, 30);
	}
	
	public void changeTextStyle(TextStyle style) {
		style.setStyle(_label);
	}

	public void hide() {
		_label.setVisible(false);
	}
	
	public void show() {
		_label.setVisible(true);
	}
	
	@Override
	public JComponent getComponent() {
		return _label;
	}
}
