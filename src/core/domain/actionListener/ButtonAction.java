package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import core.net.Message;
import core.net.ServerConnection;

public abstract class ButtonAction implements ActionListener {

	protected Message _msg;
	protected List<Object> _content;
	
	public ButtonAction() {
		_content = new ArrayList<Object>();
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent e);
}
