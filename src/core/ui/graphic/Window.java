package core.ui.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Window {
	
	private Shell _shell;
	private Display _display;
	
	public Window(int width, int heigth, String name) {
		_display = new Display();
		_shell = new Shell(_display);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		_shell.setMaximized(false);
		_shell.setSize(width, heigth);
		_shell.setLocation((int)(screenSize.getWidth()/2 - _shell.getSize().x/2), (int)(screenSize.getHeight()/2 - _shell.getSize().y/2));
		_shell.setText(name);
	}

	public Shell getShell() {
		return _shell;
	}
	
	public Display getDisplay() {
		return _display;
	}
	
	public void resize(int width, int height) {
		_shell.setSize(width, height);
	}
}
