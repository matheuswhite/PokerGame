package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import core.net.Message;
import core.net.ServerConnection;

public abstract class ButtonAction implements ActionListener {

	protected ServerConnection _connection;
	protected Message _msg;
	protected List<Object> _content;
	
	public ButtonAction(ServerConnection connection) {
		_connection = connection;
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent e);
}
