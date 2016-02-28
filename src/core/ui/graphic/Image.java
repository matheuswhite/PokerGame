package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;

public abstract class Image extends Graphic {

	private org.eclipse.swt.graphics.Image _image;
	private String _currentFilePath;
	
	public Image(long id, short layer, Rectangle bounds, String filePath) {
		super(id, layer, bounds);
		
		_label = null;
		_currentFilePath = filePath;
	}

	private void load(String filePath, Renderer renderer) {
		_image = new org.eclipse.swt.graphics.Image(renderer.getDisplay(), filePath); 
	}
	
	@Override
	public void draw(Renderer renderer) {
		load(_currentFilePath, renderer);
		if (_label == null) 
			_label = new Label(renderer.getShell(), SWT.None );
		
		_label.setImage(_image);
		_label.setBounds(_bounds);
	}

	public void changeCurrentFilePath(String filePath) {
		_currentFilePath = filePath;
	}
}
