package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.TextStyle;

public class MessagePopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5045908278747137388L;

	private Label _message;
	
	public MessagePopUp(JFrame owner, String title, String message) {
		super(owner, title);
		
		_message = new Label(new Point(0, 0), message, new TextStyle(Color.BLACK, "Arial", 12, false, false));
		
		addContent(_message.getComponent());
		addActionToConfirmButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setSize(260, 110);
	}

}
