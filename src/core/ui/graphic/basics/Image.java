package core.ui.graphic.basics;

import java.awt.Dimension;
import java.awt.Point;
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
	private BufferedImage _croppedImage;
	private boolean _isCropped;
	
	public Image(Rectangle bounds, String filePath) {
		_label = new JLabel();
		load(filePath);
				
		_label.setIcon(new ImageIcon(_bigImage));
		_label.setLocation(bounds.x, bounds.y);
		_label.setSize(bounds.width, bounds.height);
		_isCropped = false;
	}
	
	private void load(String filePath) {
		try {
			_bigImage = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resize(Dimension size, boolean isFast) {
		BufferedImage image = null;
		if (_isCropped) {
			image = _croppedImage;
		}
		else {
			image = _bigImage;
		}
		
		ImageIcon icon = new ImageIcon(image.getScaledInstance(size.width, size.height, isFast ? java.awt.Image.SCALE_FAST : java.awt.Image.SCALE_SMOOTH));
		_label.setIcon(icon);
		_label.setSize(size);
	}
	
	public void resize(double percentage, boolean isFast) {
		BufferedImage image = null;
		if (_isCropped) {
			image = _croppedImage;
		}
		else {
			image = _bigImage;
		}
		
		int w = (int)(image.getWidth() * percentage);
		int h = (int)(image.getHeight() * percentage);
		
		resize(new Dimension(w, h), isFast);
	}
	
	public void crop(Rectangle source) {
		_croppedImage = _bigImage.getSubimage(source.x, source.y, source.width, source.height);
		_label.setIcon(new ImageIcon(_croppedImage));
		_label.setSize(source.width, source.height);
		_isCropped = true;
	}
	
	public void setLocation(Point point) {
		_label.setLocation(point);
	}
	
	public void hide() {
		_label.setVisible(false);
	}
	
	public void show() {
		_label.setVisible(true);
	}
	
	@Override
	public JComponent getComponent() {
		return _label;
	}
}
