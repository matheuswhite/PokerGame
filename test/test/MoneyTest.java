package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.domain.game.Money;
import core.service.PrefixMultiplier;

public class MoneyTest {

	private Money _money1;
	private Money _money2;
	private Money _expected;
	
	@Test
	public void testAddMoneySamePrefix() {
		_money1 = new Money(100, PrefixMultiplier.GIGA);
		_money2 = new Money(120, PrefixMultiplier.GIGA);
		
		_money1.addMoney(_money2);
		_expected = new Money(220, PrefixMultiplier.GIGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testAddMoneyIncreasePrefix_Exact() {
		_money1 = new Money(980, PrefixMultiplier.MEGA);
		_money2 = new Money(20, PrefixMultiplier.MEGA);
		
		_money1.addMoney(_money2);
		_expected = new Money(1, PrefixMultiplier.GIGA);
		
		assertEquals(_money1, _expected);
	}

	@Test
	public void testAddMoneyIncreasePrefix_Left() {
		_money1 = new Money(900, PrefixMultiplier.MEGA);
		_money2 = new Money(200, PrefixMultiplier.MEGA);
		
		_money1.addMoney(_money2);
		_expected = new Money(1.1, PrefixMultiplier.GIGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testAddMoneyIncreasePrefix_TwoPrefix() {
		_money1 = new Money(200, PrefixMultiplier.MEGA);
		_money2 = new Money(3, PrefixMultiplier.GIGA);
		
		_money1.addMoney(_money2);
		_expected = new Money(3.2, PrefixMultiplier.GIGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testAddMoneyIncreasePrefix_PrefixLow() {
		_money1 = new Money(999.990, PrefixMultiplier.MEGA);
		_money2 = new Money(10, PrefixMultiplier.KILO);
		
		_money1.addMoney(_money2);
		_expected = new Money(1, PrefixMultiplier.GIGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testAddMoneyUpperLimit_Exact() {
		_money1 = new Money(990, PrefixMultiplier.TERA);
		_money2 = new Money(10, PrefixMultiplier.TERA);
		
		_money1.addMoney(_money2);
		_expected = new Money(1000, PrefixMultiplier.TERA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testAddMoneyUpperLimit_Left() {
		_money1 = new Money(990, PrefixMultiplier.TERA);
		_money2 = new Money(100, PrefixMultiplier.TERA);
		
		_money1.addMoney(_money2);
		_expected = new Money(1000, PrefixMultiplier.TERA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testRemoveMoneySamePrefix() {
		_money1 = new Money(120, PrefixMultiplier.GIGA);
		_money2 = new Money(100, PrefixMultiplier.GIGA);
		
		_money1.removeMoney(_money2);
		_expected = new Money(20, PrefixMultiplier.GIGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testRemoveMoneyDecreasePrefix_TwoPrefix() {
		_money1 = new Money(1, PrefixMultiplier.GIGA);
		_money2 = new Money(100, PrefixMultiplier.MEGA);
		
		_money1.removeMoney(_money2);
		_expected = new Money(900, PrefixMultiplier.MEGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testRemoveMoneyDecreasePrefix_PrefixLow() {
		_money1 = new Money(1, PrefixMultiplier.GIGA);
		_money2 = new Money(1, PrefixMultiplier.KILO);
		
		_money1.removeMoney(_money2);
		_expected = new Money(999.999, PrefixMultiplier.MEGA);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testRemoveMoneyLowerLimit_Exact() {
		_money1 = new Money(100, PrefixMultiplier.GIGA);
		_money2 = new Money(100, PrefixMultiplier.GIGA);
		
		_money1.removeMoney(_money2);
		_expected = new Money(0, PrefixMultiplier.NONE);
		
		assertEquals(_money1, _expected);
	}
	
	@Test
	public void testRemoveMoneyLowerLimit_Left() {
		_money1 = new Money(100, PrefixMultiplier.GIGA);
		_money2 = new Money(120, PrefixMultiplier.GIGA);
		
		_money1.removeMoney(_money2);
		_expected = new Money(0, PrefixMultiplier.NONE);
		
		assertEquals(_money1, _expected);
	}
}
