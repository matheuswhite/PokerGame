package core.ui.graphic.basics;

import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.service.Range;
import core.ui.UI_Element;

public class Slider implements UI_Element {

	private JPanel _panel;
	private JSlider _slider;
	private Label _labelValue;
	private int _value;
	
	public Slider(Point location, Range range, TextStyle valueStyle) {
		_slider = new JSlider(range.getInitialIndex(), range.getFinalIndex(), range.getInitialIndex());
		_value = range.getInitialIndex();
		_labelValue = new Label(new Point(0, 0), Integer.toString(_value), valueStyle);
		
		_slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				_value = _slider.getValue();
				_labelValue.setText(Integer.toString(_value));
			}
		});
		
		_panel = new JPanel();
		
		_panel.add(_slider);
		_panel.add(_labelValue.getComponent());
		_panel.setLocation(location);
		_panel.setSize(160, 30);
	}
	
	public void setRange(Range range) {
		_slider.setMinimum(range.getInitialIndex());
		_slider.setMaximum(range.getFinalIndex());
	}
	
	public int getValue() {
		return _value;
	}
	
	@Override
	public JComponent getComponent() {
		return _panel;
	}

}
