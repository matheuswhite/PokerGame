package core.ui.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Label;

public class TextStyle {

	private Font _font;
	private boolean _fontChange;
	
	private Color _textColor;
	private String _fontName;
	private int _fontSize;
	private boolean _boldFlag;
	private boolean _italicFlag;
	
	public TextStyle(Color textColor, String fontName, int fontSize, boolean isBold, boolean isItalic) {
		_textColor = textColor;
		_fontName = fontName;
		_fontSize = fontSize;
		_boldFlag = isBold;
		_italicFlag = isItalic;
		_fontChange = true;
	}
	
	public void setStyle(Renderer renderer, Label label) {
		int flag = (_boldFlag ? SWT.BOLD : (_italicFlag ? SWT.ITALIC : SWT.None));
		
		if (_fontChange || _font == null) {
			_font = new Font(renderer.getDisplay(), new FontData(getFontName(), _fontSize, flag));
			label.setFont(_font);
			_fontChange = false;
		}
		label.setForeground(_textColor);
	}

	public Color getTextColor() {
		return _textColor;
	}

	public void setTextColor(Color textColor) {
		_textColor = textColor;
	}

	public String getFontName() {
		return _fontName;
	}

	public void setFontName(String fontName) {
		_fontName = fontName;
		_fontChange = true;
	}
	
	public int getFontSize() {
		return _fontSize;
	}

	public void setFontSize(int fontSize) {
		_fontSize = fontSize;
		_fontChange = true;
	}
	
	public boolean isBold() {
		return _boldFlag;
	}

	public void setBoldFlag(boolean boldFlag) {
		_boldFlag = boldFlag;
		_fontChange = true;
	}
	
	public boolean isItalic() {
		return _italicFlag;
	}

	public void setItalicFlag(boolean italicFlag) {
		_italicFlag = italicFlag;
		_fontChange = true;
	}
}
