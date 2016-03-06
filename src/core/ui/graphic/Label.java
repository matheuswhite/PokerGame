package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import core.ui.UI_Element;

public class Label extends UI_Element {

	private String _text;
	private TextStyle _style;
	
	public Label(int layer, Rectangle bounds, String text, TextStyle style) {
		super(layer, bounds);
		
		_text = text;
		_style = style;
	}
	
	@Override
	public void draw(Renderer renderer) {
		if (_label == null) 
			_label = new org.eclipse.swt.widgets.Label(renderer.getShell(), SWT.None );
		
		_label.setText(_text);
		_style.setStyle(renderer, _label);
		_label.setBounds(_bounds);
	}
}
