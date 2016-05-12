package core.domain.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import core.net.Message;

public abstract class Action implements ActionListener {

	protected Message _msg;
	protected List<Object> _content;
	
	public Action() {
		_content = new ArrayList<Object>();
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent e);
}
