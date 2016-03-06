package core.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;

import core.ui.graphic.Window;

public abstract class Button {

	private Window _window;
	private org.eclipse.swt.widgets.Button _button;
	
	public Button(Window window, Point location, Point size, String text, Color backgroundColor, Color textColor) {
		
		_window = window;
		_button = null;
		draw(location, size, text, backgroundColor, textColor);
	}
	
	private void draw(Point location, Point size, String text, Color backgroundColor, Color textColor) {
		_button = new org.eclipse.swt.widgets.Button(_window.getShell(), SWT.PUSH);
		_button.setBounds(_window.getShell().getClientArea());
		
		setLocation(location);
		setSize(size);
		setBackgroundColor(backgroundColor);
		setText(text);
		setForegroundColor(textColor);
		setSelectionListener(createSelectionListener());
	}
	
	public abstract SelectionListener createSelectionListener();
	
	public void setSelectionListener(SelectionListener selectionListener) {
		_button.addSelectionListener(selectionListener);
	}

	public void setLocation(Point location) {
		_button.setLocation(location);
	}
	
	public void setSize(Point size) {
		_button.setSize(size);
	}
	
	public void setForegroundColor(Color textColor) {
		_button.setForeground(textColor);
	}

	public void setText(String text) {
		_button.setText(text);
	}

	public void setBackgroundColor(Color backgroundColor) {
		_button.setBackground(backgroundColor);
	}

	public void erase() {
		_button.dispose();
	}
}
