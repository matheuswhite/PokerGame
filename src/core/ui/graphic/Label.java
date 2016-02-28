package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;

public class Label extends Graphic {

	private String _text;
	private TextStyle _style;
	
	public Label(long id, short layer, Rectangle bounds, String text, TextStyle style) {
		super(id, layer, bounds);
		
		_text = text;
		_style = style;
	}

	public void setText(String text) {
		_text = text;
	}
	
	public void setTextStyle(TextStyle style) {
		_style = style;
	}
	
	public TextStyle getTextStyle() {
		return _style;
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
