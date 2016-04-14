package core;

import core.ui.graphic.screen.ConnectionTestScreen;
import core.ui.graphic.screen.MatchScreen;

public class Launcher {
	
	public static void main(String[] args) {
		//ConnectionTestScreen screen = new ConnectionTestScreen();
		MatchScreen screen = new MatchScreen(2049);
	}
}
