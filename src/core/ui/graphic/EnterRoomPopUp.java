package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.domain.Money;
import core.domain.PlayerInfo;
import core.domain.PlayerStats;
import core.domain.Room;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.TextStyle;
import core.ui.graphic.screen.MatchScreen;
import core.ui.input.MoneyInput;

public class EnterRoomPopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 824213959521958735L;
	
	private Label _message;
	private MoneyInput _moneyInput;
	private Room _room;
	
	public EnterRoomPopUp(JFrame owner, String title) {
		super(owner, title);
		
		_message = new Label(new Point(0, 0), "Enter with the Buy In value", new TextStyle(Color.BLACK, "Arial", 12, true, true));
		_moneyInput = new MoneyInput(new Point(0, 20));
		
		addContent(_message.getComponent());
		addContent(_moneyInput.getComponent());
		
		setSize(260, 150);
		
		addActionToConfirmButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Money buyIn = _moneyInput.getValue();
				
				if (buyIn.parseToLong() < _room.getMatchInfo().getMinimumBuyIn().parseToLong()) {
					JOptionPane.showMessageDialog(owner, "The minimun BuyIn is " + _room.getMatchInfo().getMinimumBuyIn().toString());
				}
				else if (buyIn.parseToLong() > PlayerStats.Instance().getMoney().parseToLong()) {
					JOptionPane.showMessageDialog(owner, "The maximun BuyIn is " + PlayerStats.Instance().getMoney().toString());
				}
				else {
					setVisible(false);
					owner.setVisible(false);
					PlayerStats.Instance().getMoney().removeMoney(buyIn);
					PlayerInfo.Instance().setMoneyPlayer(buyIn);
					new MatchScreen(owner, _room);
				}
			}
			
		});
	}
	
	public void setRoom(Room room) {
		_room = room;
		setTitle("Do you enter in the Room" + room.getId() + " ?");
	}
}
