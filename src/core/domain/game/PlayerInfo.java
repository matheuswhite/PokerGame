package core.domain.game;

import core.service.PrefixMultiplier;

public class PlayerInfo {
	private Long _id;
	private Card[] _hand;
	private Money _moneyPlayer;
	private Money _moneyBetting;
	private String _name;
	private int _seat;
	private boolean _inGame;
	
	public PlayerInfo() {
		_id = null;
		_hand = new Card[2];
		_moneyPlayer = new Money(0, PrefixMultiplier.NONE);
		_name = "Player";
		_moneyBetting = new Money();
		_inGame = false;
	}
	
	public void setId(long id) {
		_id = id;
		setName(_name + id);
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
	public void setMoneyPlayer(Money money) {
		_moneyPlayer = money;
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
	public Money getMoneyBetting() {
		return _moneyBetting;
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
	
	public boolean isInGame() {
		return _inGame;
	}
	
	public void setInGame() {
		_inGame =!_inGame;
	}
}
