package core.domain;

import core.service.PrefixMultiplier;
import core.storage.JSON_File;
import core.storage.Storage;

public class PlayerStats {
	
	private static PlayerStats _instance = null;
	
	private String _name;
	private Money _money;
	private int _wins;
	private int _losses;
	
	private PlayerStats(long id) {
		_name = "player" + id;
		_money = new Money(10, PrefixMultiplier.KILO);
		_wins = 0;
		_losses = 0;
	}
	
	public static synchronized PlayerStats Instance() {
		if (_instance == null)
			create();
		return _instance;
	}
	
	private static void create() {
		String file = "src/data/playerStats.json";
		
		Storage storage = JSON_File.Instance();
		if (storage.exist(file)) {
			_instance = storage.load(file, PlayerStats.class);
		}
		else {
			_instance = new PlayerStats(PlayerInfo.Instance().getId());
			storage.save(file, _instance);
		}
	}

	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public Money getMoney() {
		return _money;
	}
	
	public void addOneWin() {
		_wins++;
	}
	
	public int getWins() {
		return _wins;
	}
	
	public void addOneLoss() {
		_losses++;
	}
	
	public int getLosses() {
		return _losses;
	}
}
