package core;

import core.domain.Money;
import core.domain.PlayerInfo;
import core.domain.PlayerStats;
import core.domain.Room;
import core.service.PrefixMultiplier;
import core.ui.graphic.screen.ConnectionTestScreen;
import core.ui.graphic.screen.MainScreen;
import core.ui.graphic.screen.MatchScreen;

public class Launcher {
	
	public static void main(String[] args) {
		PlayerInfo.Create(2114);
		//ConnectionTestScreen screen = new ConnectionTestScreen();
		MatchScreen screen = new MatchScreen(new Room(2415, new Money(100, PrefixMultiplier.NONE), new Money(5, PrefixMultiplier.KILO)));
		//MainScreen screen = new MainScreen();
	}
}
