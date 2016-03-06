package core.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;

import core.ui.UI_Element;
import core.ui.graphic.Renderer;

public class Button extends UI_Element {

	private org.eclipse.swt.widgets.Button _button;
	private String _text;
	private Color _backgroundColor;
	private Color _textColor;
	private SelectionListener _selectionListener;
	
	public Button(int layer, Rectangle bounds, String text, Color backgroundColor, Color textColor, SelectionListener selectionListener) {
		super(layer, bounds);
		
		_text = text;
		_textColor = textColor;
		_backgroundColor = backgroundColor;
		_selectionListener = selectionListener;
	}

	@Override
	public void draw(Renderer renderer) {
		if (_button == null)
			_button = new org.eclipse.swt.widgets.Button(renderer.getShell(), SWT.PUSH);
		
		_button.addSelectionListener(_selectionListener);
		_button.setBackground(_backgroundColor);
		_button.setText(_text);
		_button.setForeground(_textColor);
	}
}
