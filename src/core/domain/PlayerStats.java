package core.domain;

import core.service.PrefixMultiplier;

public class PlayerStats {
	
	private String _name;
	private Money _money;
	private int _wins;
	private int _losses;
	
	public PlayerStats(long id) {
		_name = "player" + id;
		_money = new Money(10, PrefixMultiplier.KILO);
		_wins = 0;
		_losses = 0;
	}
	
	public PlayerStats(String name, Money money, int wins, int losses) {
		_name = name;
		_money = money;
		_wins = wins;
		_losses = losses;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setMoney(Money newValue) {
		_money = newValue;
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
