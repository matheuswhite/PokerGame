package core;

import core.ui.graphic.*;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public class Launcher {
	
	public static void main(String[] args) {
		Renderer renderer = new Renderer();
		renderer.getShell().setMaximized(false);
		renderer.getShell().setSize(600, 480);
		renderer.getShell().setLocation(100, 100);
		renderer.getShell().setText("PokerGame");
		
		Color black = new Color(renderer.getDisplay(), new RGB(0, 0, 0));
		TextStyle style = new TextStyle(black, "Arial", 12, false, false);
		Label l = new Label(1, 0, new Rectangle(50, 50, 110, 20), "Test Label!", style);
		renderer.createGraphic(l);
		
		
		renderer.getShell().open();
		while (!renderer.getShell().isDisposed())
		{
			if (!renderer.getDisplay().readAndDispatch())
				renderer.getDisplay().sleep();
		}
		renderer.getDisplay().dispose();
	}
}
