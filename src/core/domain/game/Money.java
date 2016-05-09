package core.domain.game;

import core.service.PrefixMultiplier;

public class Money {
	
	private double _value;
	private PrefixMultiplier _prefixMultiplier;
	
	public Money() {
		_value = 0;
		_prefixMultiplier = PrefixMultiplier.NONE;
	}
	
	public Money(double value, PrefixMultiplier prefixMultiplier) {
		if (_value >= 1000)
			throw new IllegalArgumentException("The value must be less that 1000");
		
		_value = value;
		_prefixMultiplier = prefixMultiplier;
	}
	
	public double getValue() {
		return _value;
	}
	
	public PrefixMultiplier getPrefixMultiplier() {
		return _prefixMultiplier;
	}
	
	@Override
	public String toString() {
		return _value + _prefixMultiplier.toString();
	}
	
	public long parseToLong() {
		return (long) (_value * Math.pow(10, _prefixMultiplier.getValue()));
	}
	
	public void addMoney(Money money) {
		if (_value == 1000 && _prefixMultiplier.equals(PrefixMultiplier.TERA))
			throw new IllegalArgumentException("The max value of money has been reached");
		
		long totalValue = parseToLong() + money.parseToLong();
		PrefixMultiplier prefix = PrefixMultiplier.NONE;
		int value = (int)totalValue;
		
		if (totalValue / Math.pow(10, PrefixMultiplier.TERA.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.TERA.getValue()));
			prefix = PrefixMultiplier.TERA;
			if (value >= 1000)
				value = 1000;
		}
		else if (totalValue / Math.pow(10, PrefixMultiplier.GIGA.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.GIGA.getValue()));
			prefix = PrefixMultiplier.GIGA;
		}
		else if (totalValue / Math.pow(10, PrefixMultiplier.MEGA.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.MEGA.getValue()));
			prefix = PrefixMultiplier.MEGA;
		}
		else if (totalValue / Math.pow(10, PrefixMultiplier.KILO.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.KILO.getValue()));
			prefix = PrefixMultiplier.KILO;
		}
		
		_value = value;
		_prefixMultiplier = prefix;
	}

	
	public void removeMoney(Money money) {
		if (_value == 0)
			throw new IllegalArgumentException("The value of money already is minimum");
		
		long totalValue = parseToLong() - money.parseToLong();
		PrefixMultiplier prefix = PrefixMultiplier.NONE;
		int value = (int)totalValue;
		
		if (totalValue / Math.pow(10, PrefixMultiplier.TERA.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.TERA.getValue()));
			prefix = PrefixMultiplier.TERA;
		}
		else if (totalValue / Math.pow(10, PrefixMultiplier.GIGA.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.GIGA.getValue()));
			prefix = PrefixMultiplier.GIGA;
		}
		else if (totalValue / Math.pow(10, PrefixMultiplier.MEGA.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.MEGA.getValue()));
			prefix = PrefixMultiplier.MEGA;
		}
		else if (totalValue / Math.pow(10, PrefixMultiplier.KILO.getValue()) > 0) {
			value = (int) (totalValue / Math.pow(10, PrefixMultiplier.KILO.getValue()));
			prefix = PrefixMultiplier.KILO;
		}
		else if (totalValue <= 0) {
			value = 0;
		}
		
		_value = value;
		_prefixMultiplier = prefix;
	}
}
