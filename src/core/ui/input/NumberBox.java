package core.ui.input;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.NumberFormat;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

import core.ui.UI_Element;

public class NumberBox implements UI_Element {

	private JFormattedTextField _textField;
	private NumberFormatter _formatter;
	
	public NumberBox(Rectangle bounds, int min, int max) {
		NumberFormat format = NumberFormat.getInstance();
		_formatter = new NumberFormatter(format);
		_formatter.setValueClass(Integer.class);
		_formatter.setMinimum(min);
		_formatter.setMaximum(max);
		_formatter.setCommitsOnValidEdit(true);
		
		_textField = new JFormattedTextField(_formatter);
		_textField.setLocation(bounds.x, bounds.y);
		_textField.setSize(bounds.width, bounds.height);
	}

	public int getValue() {
		return Integer.parseInt(_textField.getText());
	}
	
	public void setLocation(Point location) {
		_textField.setLocation(location);
	}
	
	public void resize(Dimension size) {
		_textField.setSize(size);
	}
	
	public void setMinimum(int min) {
		((NumberFormatter)_textField.getFormatter()).setMinimum(min);
	}
	
	public void setMaximum(int max) {
		((NumberFormatter)_textField.getFormatter()).setMaximum(max);
	}
	
	@Override
	public JComponent getComponent() {
		return _textField;
	}

}
