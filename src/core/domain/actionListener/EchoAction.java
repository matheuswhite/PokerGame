package core.domain.actionListener;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import core.domain.Money;
import core.domain.PlayerInfo;
import core.net.Message;
import core.net.ServerConnection;
import core.service.PrefixMultiplier;

public class EchoAction extends ButtonAction {

	private PlayerInfo playerInfo;
	
	public EchoAction(ServerConnection connection) {
		super(connection);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		playerInfo = new PlayerInfo(3);
		playerInfo.setSeat(1);
		playerInfo.addMoney(new Money(54, PrefixMultiplier.MEGA));
		
		_content = new ArrayList<Object>();
		_content.add(new Money(3, PrefixMultiplier.KILO));
		_content.add(playerInfo);
		
		_msg = new Message(1.0, "echo", _content);
		
		try {
			_connection.write(_msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
