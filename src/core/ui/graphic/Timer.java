package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.util.TimerTask;

import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.TextStyle;
import core.ui.graphic.basics.Window;

public class Timer {
	private java.util.Timer _timer;
	private TimerTask _timerTask;
	private Label _label;
	
	private java.util.Timer _tick;
	private int _milisecond;
	private int _currentMilisecond;
	private TimerTask _tickTask;
	
	public Timer(Window window, Point location, int milisecond, TimerTask task) {
		_timer = new java.util.Timer();
		_milisecond = milisecond + 1000;
		_currentMilisecond = _milisecond - 1000;
		_timerTask = task;
		
		_label = new Label(location, Integer.toString((_milisecond-1000)/1000), new TextStyle(Color.WHITE, "Arial", 38, true, false));
		_label.hide();
		
		
		_tick = new java.util.Timer();
		_tickTask = new TimerTask() {
			
			@Override
			public void run() {
				_label.setText(Integer.toString(_currentMilisecond/1000));
				_currentMilisecond -= 1000;
			}
		};
		
		window.addComponent(_label);
	}
	
	public void start() {
		_label.show();
		_timer.schedule(_timerTask, _milisecond);
		_tick.schedule(_tickTask, 0, 1000);
	}
	
	public void stop() {
		_label.hide();
		_label.setText(Integer.toString((_milisecond-1000)/1000));
		_timer.cancel();
		_tick.cancel();
		_currentMilisecond = _milisecond;
	}
}
