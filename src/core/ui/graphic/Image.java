package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;

import core.ui.UI_Element;

public class Image extends UI_Element {

	private org.eclipse.swt.graphics.Image _image;
	private String _currentFilePath;
	
	public Image(int layer, Rectangle bounds, String filePath) {
		super(layer, bounds);
		
		_label = null;
		_currentFilePath = filePath;
	}
	
	@Override
	public void draw(Renderer renderer) {
		_image = new org.eclipse.swt.graphics.Image(renderer.getDisplay(), _currentFilePath);
		if (_label == null) 
			_label = new Label(renderer.getShell(), SWT.None );
		
		_label.setImage(_image);
		_label.setBounds(_bounds);
	}
}
