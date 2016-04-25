package core.ui.input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import core.ui.UI_Element;

public class Button implements UI_Element {
	
	private JButton _button;
	
	public Button(Rectangle bounds, String text, Color backgroundColor, Color textColor, ActionListener actionListener) {
		_button = new JButton(text);
		
		_button.setLocation(bounds.x, bounds.y);
		_button.setSize(bounds.width, bounds.height);
		_button.setForeground(textColor);
		_button.setBackground(backgroundColor);
		_button.addActionListener(actionListener);
	}

	public void setLocation(Point location) {
		_button.setLocation(location);
	}
	
	public void resize(Dimension size) {
		_button.setSize(size);
	}
	
	public void setTextColor(Color textColor) {
		_button.setForeground(textColor);
	}

	public void setText(String text) {
		_button.setText(text);
	}

	public void setBackgroundColor(Color backgroundColor) {
		_button.setBackground(backgroundColor);
	}
	
	public void addActionListener(ActionListener actionListener) {
		_button.addActionListener(actionListener);
	}

	public void enable() {
		_button.setEnabled(true);
	}
	
	public void disable() {
		_button.setEnabled(false);
	}
	
	@Override
	public JComponent getComponent() {
		return _button;
	}
}
