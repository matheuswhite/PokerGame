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
		
		Color black = new Color(window.getDisplay(), new RGB(0, 0, 0));
		Color white = new Color(window.getDisplay(), new RGB(1, 1, 1));
		Color red = new Color(window.getDisplay(), new RGB(1, 0, 0));
		Color green = new Color(window.getDisplay(), new RGB(0, 1, 0));
		Color blue = new Color(window.getDisplay(), new RGB(0, 0, 1));
		
		TextStyle style = new TextStyle(green, "Arial", 12, false, false);
		Label l = new Label(window, new Point(50, 50), "Test Label!", style);

		Button b = new Button(window, new Point(50, 100), new Point(150, 50), "Change label text", null, red) {
			
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
