package core;

import core.ui.graphic.*;
import core.ui.input.Button;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;

public class Launcher {
	
	public static void main(String[] args) {
		Window window = new Window(700, 500, "PokerGame");
		Map<String, Color> colors = new HashMap<String, Color>();
		
		colors.put("black", new Color(window.getDisplay(), new RGB(0, 0, 0)));
		colors.put("red", new Color(window.getDisplay(), new RGB(1, 0, 0)));
		colors.put("green", new Color(window.getDisplay(), new RGB(0, 1, 0)));
		colors.put("blue", new Color(window.getDisplay(), new RGB(0, 0, 1)));
		colors.put("white", new Color(window.getDisplay(), new RGB(1, 1, 1)));
		
		TextStyle style = new TextStyle(colors.get("black"), "Arial", 12, false, false);
		Label l = new Label(window, new Point(50, 50), "Test Label!", style);

		Button b = new Button(window, new Point(50, 100), new Point(100, 50), "Change label text", colors.get("red"), colors.get("white")) {
			
			@Override
			public SelectionListener createSelectionListener() {
				return new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						l.setText("Changed1!");
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						l.setText("Changed2!");
					}
				};
			}
		};
		
		window.getShell().open();
		while (!window.getShell().isDisposed())
		{
			if (!window.getDisplay().readAndDispatch())
				window.getDisplay().sleep();
		}
		window.getDisplay().dispose();
	}
}
