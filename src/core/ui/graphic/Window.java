package core.ui.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.ui.UI_Element;

public class Window {
	
	private JFrame _frame;
	private JPanel _defaltPanel;
	
	public Window(int width, int height, String name) {
		_frame = new JFrame(name);
		_defaltPanel = new JPanel(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		_defaltPanel.setLocation(0,0);
		_defaltPanel.setSize(width, height);
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.add(_defaltPanel);
		_frame.setSize(width, height);
		_frame.setLocation((int)(screenSize.getWidth()/2 - _frame.getSize().width/2), (int)(screenSize.getHeight()/2 - _frame.getSize().height/2));
		_frame.setVisible(true);
		_frame.setResizable(false);
	}
	
	protected void addComponent(UI_Element element) {
		_defaltPanel.add(element.getComponent());
		_defaltPanel.repaint();
	}
	
	protected void removeComponent(UI_Element element, String panel) {
		_defaltPanel.remove(element.getComponent());
		_defaltPanel.repaint();
	}
}
