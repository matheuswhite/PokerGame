package core.ui.input;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.service.PrefixMultiplier;

public class Raise_BetInput {

	private Button _raise_betButton;
	private NumberBox _raise_betValue;
	private Button _prefixMultiplierButton;
	private PrefixMultiplier _prefixMultiplier;
	
	public Raise_BetInput(Point point, ActionListener actionListener) {
		
		_raise_betButton = new Button(new Rectangle(point.x, point.y, 80, 50), "Raise", Color.BLUE, Color.WHITE, actionListener);
		_raise_betValue = new NumberBox(new Rectangle(point.x - 110, point.y + 10, 50, 30), 1, 999);
		
		_prefixMultiplier = PrefixMultiplier.NONE;
		_prefixMultiplierButton = new Button(new Rectangle(point.x - 55, point.y, 50, 50), "_", Color.BLUE, Color.WHITE, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (_prefixMultiplier) {
				case NONE:
					_prefixMultiplier = PrefixMultiplier.KILO;
					_prefixMultiplierButton.setText(_prefixMultiplier.toString());
					break;
				case KILO:
					_prefixMultiplier = PrefixMultiplier.MEGA;
					_prefixMultiplierButton.setText(_prefixMultiplier.toString());
					break;
				case MEGA:
					_prefixMultiplier = PrefixMultiplier.GIGA;
					_prefixMultiplierButton.setText(_prefixMultiplier.toString());
					break;
				case GIGA:
					_prefixMultiplier = PrefixMultiplier.TERA;
					_prefixMultiplierButton.setText(_prefixMultiplier.toString());
					break;
				case TERA:
					_prefixMultiplier = PrefixMultiplier.NONE;
					_prefixMultiplierButton.setText("_");
					break;
				default:
					break;
				}
			}
		});
	}
	
	public Button getButton() {
		return _raise_betButton;
	}
	
	public NumberBox getValue() {
		return _raise_betValue;
	}
	
	public Button getPrefixMultiplierButton() {
		return _prefixMultiplierButton;
	}
	
	public PrefixMultiplier getPrefixMultiplierValue() {
		return _prefixMultiplier;
	}

	public void disable() {
		_raise_betButton.disable();
	}
	
	public void enable() {
		_raise_betButton.enable();
	}
}
