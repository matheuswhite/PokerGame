package core;

import core.domain.PlayerInfo;
import core.ui.graphic.screen.ConnectionTestScreen;
import core.ui.graphic.screen.MainScreen;
import core.ui.graphic.screen.MatchScreen;

public class Launcher {
	
	public static void main(String[] args) {
		PlayerInfo.Create(2114);
		//ConnectionTestScreen screen = new ConnectionTestScreen();
		//MatchScreen screen = new MatchScreen(2415);
		MainScreen screen = new MainScreen();
	}
}
