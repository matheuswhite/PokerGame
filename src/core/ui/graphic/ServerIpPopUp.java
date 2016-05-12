package core.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import core.domain.game.PlayerInfo;
import core.net.ServerConnection;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.screen.MainScreen;

public class ServerIpPopUp extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1923962866765197333L;
	
	private JButton _confirmButton;
	private JFormattedTextField _textBox;
	private JPanel _panel;
	
	public ServerIpPopUp(MainScreen owner, PlayerInfo playerInfo) {
		super(owner.getFrame(), "Enter with server IP", false);
		
		_confirmButton = new JButton("Yes");
		
		try {
			MaskFormatter formatter = new MaskFormatter("###.###.###.###");
			formatter.setPlaceholderCharacter('0');
			_textBox = new JFormattedTextField(formatter);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		_panel = new JPanel();
		_panel.add(_textBox);
		_panel.add(_confirmButton);
		
		add(_panel);
		pack();
		setLocationRelativeTo(owner.getFrame());
		setResizable(false);
		setAlwaysOnTop(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		_confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String serverIp = _textBox.getText();
				
				try {
					ServerConnection.Create(playerInfo);
					ServerConnection.Instance().connect(serverIp);
					ServerConnection.Instance().start();
					
					ServerConnection.Instance().getMessageHandler().setMainScreen(owner);
					
				} catch (SocketTimeoutException e1) {
					PopUp popUp = new MessagePopUp(owner.getFrame(), "Server Ip invalid!", "Enter with server Ip valid!");
					popUp.setVisible(true);
				} catch (IOException e2) {
					e2.printStackTrace();
				} 
			}
		});
	}	
}
