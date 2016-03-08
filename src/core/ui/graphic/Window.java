package core.ui.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	
	private JFrame _frame;
	private JPanel _panel;
	
	public Window(int width, int height, String name) {
		_frame = new JFrame(name);
		_panel = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.add(_panel);
		_frame.setSize(width, height);
		_frame.setLocation((int)(screenSize.getWidth()/2 - _frame.getSize().width/2), (int)(screenSize.getHeight()/2 - _frame.getSize().height/2));
		_frame.setVisible(true);
	}
	
	public void addComponent(JComponent element) {
		_panel.add(element);
	}
	
	public void removeComponent(JComponent element) {
		_panel.remove(element);
	}
}
