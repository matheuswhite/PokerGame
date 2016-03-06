package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;

public class Image {

	private Window _window;
	private Label _label;
	
	public Image(Window window, Rectangle bounds, String filePath) {
		
		_window = window;
		_label = null;
		draw(filePath, bounds);
	}

	public void loadNewImage(String filePath) {
		org.eclipse.swt.graphics.Image image = new org.eclipse.swt.graphics.Image(_window.getDisplay(), filePath);
		_label.setImage(image);
	}
	
	public void resize(Rectangle bounds) {
		_label.setBounds(bounds);
	}
	
	private void draw(String filePath, Rectangle bounds) {
		_label = new Label(_window.getShell(), SWT.None );
		loadNewImage(filePath);
		if (bounds != null) resize(bounds);
	}
	
	public void erase() {
		_label.dispose();
	}
}
