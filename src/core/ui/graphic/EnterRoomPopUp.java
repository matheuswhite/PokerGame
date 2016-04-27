package core.ui.graphic;

import javax.swing.JFrame;

import core.domain.Room;
import core.ui.graphic.basics.PopUp;

public class EnterRoomPopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 824213959521958735L;

	public EnterRoomPopUp(JFrame owner, String title, Room roomInfo) {
		super(owner, title);
		
		addContent(content);
		addActionToConfirmButton(action);
	}
}
