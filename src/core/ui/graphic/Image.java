package core.ui.graphic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import core.ui.UI_Element;

public class Image implements UI_Element {

	private JLabel _label;
	private BufferedImage _bigImage;
	
	public Image(Rectangle bounds, String filePath) {
		_label = new JLabel();
		load(filePath);
				
		_label.setIcon(new ImageIcon(_bigImage));
		_label.setLocation(bounds.x, bounds.y);
		_label.setSize(bounds.width, bounds.height);
	}
	
	private void load(String filePath) {
		try {
			_bigImage = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resize(Dimension size) {
		_label.setSize(size.width, size.height);
	}
	
	public void crop(Rectangle source) {
		BufferedImage image = _bigImage.getSubimage(source.x, source.y, source.width, source.height);
		_label.setIcon(new ImageIcon(image));
		_label.setSize(source.width, source.height);
	}

	@Override
	public JComponent getComponent() {
		return _label;
	}
}
