package core.ui.graphic.basics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TextStyle {
	
	private Color _textColor;
	private String _fontName;
	private int _size;
	private boolean _boldFlag;
	private boolean _italicFlag;
	
	public TextStyle(Color textColor, String fontName, int size, boolean isBold, boolean isItalic) {
		_textColor = textColor;
		_fontName = fontName;
		_size = size;
		_boldFlag = isBold;
		_italicFlag = isItalic;
	}
	
	public void setStyle(JLabel label) {
		label.setForeground(_textColor);
		label.setFont(new Font(_fontName, (_boldFlag ? Font.BOLD : Font.PLAIN) + (_italicFlag ? Font.ITALIC : Font.PLAIN), _size));
	}

	public Color getTextColor() {
		return _textColor;
	}

	public String getFontName() {
		return _fontName;
	}
	
	public int getSize() {
		return _size;
	}
	
	public boolean isBold() {
		return _boldFlag;
	}
	
	public boolean isItalic() {
		return _italicFlag;
	}
}
