package core.ui.input;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JTextField;

import core.ui.UI_Element;

public class TextBox implements UI_Element {

	protected JTextField _textField;
	
	public TextBox(Rectangle bounds) {
		_textField = new JTextField();
		
		_textField.setLocation(bounds.x, bounds.y);
		_textField.setSize(bounds.width, bounds.height);
	}
	
	public String getText() {
		return _textField.getText();
	}
	
	public void setLocation(Point location) {
		_textField.setLocation(location);
	}
	
	public void resize(Dimension size) {
		_textField.setSize(size);
	}
	
	@Override
	public JComponent getComponent() {
		return _textField;
	}

}
