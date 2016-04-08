package core.domain;

public enum Suit {

	HEARTS(0), SPADES(1), DIAMONDS(2), CLUBS(3);   
	
	private int _value;
	
	private Suit(int value) {
		_value = value;
	}
	
	public int getValue() {
		return _value;
	}
	
	@Override
	public String toString() {
		String out = "";
		switch (this) {
		case HEARTS:
			out = "Hearts";
			break;
		case SPADES:
			out = "Spades";
			break;
		case DIAMONDS:
			out = "Diamonds";
			break;
		case CLUBS:
			out = "Clubs";
			break;
		default:
			break;
		}
		
		return out;
	}
}
