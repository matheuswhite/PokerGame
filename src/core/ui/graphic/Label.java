package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

public class Label {

	private Window _window;
	private org.eclipse.swt.widgets.Label _label;
	
	public Label(Window window, Point Location, String text, TextStyle style) {
		
		_window = window;
		_label = null;
		draw(Location, text, style);
	}
	
	public void setLocation(Point point) {
		_label.setLocation(point);
	}
	
	public void setText(String text) {
		_label.setText(text);
	}
	
	public void changeTextStyle(TextStyle style) {
		style.setStyle(_window, _label);
	}
	
	private void draw(Point location, String text, TextStyle style) {
		_label = new org.eclipse.swt.widgets.Label(_window.getShell(), SWT.None );
		_label.setBounds(_window.getShell().getClientArea());
		
		setText(text);
		changeTextStyle(style);
		setLocation(location);
	}

	public void erase() {
		_label.dispose();
	}
}
