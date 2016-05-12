package core.ui.input;

import java.awt.Point;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import core.domain.game.Money;
import core.service.PrefixMultiplier;
import core.ui.UI_Element;

public class MoneyInput implements UI_Element {

	private JPanel _panel;
	private JComboBox<String> _comboBox;
	private JSpinner _spinner;
	
	public MoneyInput(Point location) {
		_spinner = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
		_comboBox = new JComboBox<String>(new String[]{" ", "K", "M", "G", "T"});
		
		_panel = new JPanel();
		_panel.add(_spinner);
		_panel.add(_comboBox);
		_panel.setLocation(location);
	}
	
	public Money getValue() {
		PrefixMultiplier prefix = PrefixMultiplier.NONE;
		int value =  (int) _spinner.getValue();
		
		if (_comboBox.getSelectedItem() == "K") {
			prefix = PrefixMultiplier.KILO;
		}
		else if (_comboBox.getSelectedItem() == "M") {
			prefix = PrefixMultiplier.MEGA;
		}
		else if (_comboBox.getSelectedItem() == "G") {
			prefix = PrefixMultiplier.GIGA;
		}
		else if (_comboBox.getSelectedItem() == "T") {
			prefix = PrefixMultiplier.TERA;
		}
		
		return new Money(value, prefix);
	}
	
	@Override
	public JComponent getComponent() {
		return _panel;
	}

}
