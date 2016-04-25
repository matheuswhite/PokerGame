package core.domain;

import core.service.PrefixMultiplier;

public class PlayerInfo {
	
	private static PlayerInfo _instance = null;
	
	private long _id;
	private Card[] _hand;
	private Money _moneyPlayer;
	private Money _moneyBetting;
	private String _name;
	private int _seat;
	
	private PlayerInfo(long id) {
		_id = id;
		_hand = new Card[2];
		_moneyPlayer = new Money(0, PrefixMultiplier.NONE);
		_name = "Player" + id;
		_moneyBetting = new Money();
	}
	
	public synchronized static void Create(long id) {
		if (_instance == null)
			_instance = new PlayerInfo(id);
	}
	
	public synchronized static PlayerInfo Instance() {
		return _instance;
	}
	
	public Card[] getHand() {
		return _hand;
	}
	public void setHand(Card[] hand) {
		if (hand.length != 2)
			throw new IllegalArgumentException("Number of cards invalid");
		
		_hand = hand;
	}
	
	public long getId() {
		return _id;
	}
	
	public Money getMoneyPlayer() {
		return _moneyPlayer;
	}
	public void removeMoney(Money money) {
		_moneyPlayer.removeMoney(money);
	}
	public void addMoney(Money money) {
		_moneyPlayer.addMoney(money);
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
	public void setMoneyBetting(Money _moneyBetting) {
		this._moneyBetting = _moneyBetting;
	}

	public int getSeat() {
		return _seat;
	}
	public void setSeat(int seat) {
		_seat = seat;
	}
}
