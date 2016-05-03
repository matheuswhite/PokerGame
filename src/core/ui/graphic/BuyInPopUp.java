package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import core.domain.Money;
import core.domain.PlayerInfo;
import core.domain.PlayerStats;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.TextStyle;
import core.ui.input.MoneyInput;

public class BuyInPopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 697499683971646778L;

	private Label _minBuyInLabel;
	private MoneyInput _minBuyInInput;
	
	private MessagePopUp _messagePopUp;
	
	public BuyInPopUp(JFrame owner, String title) {
		super(owner, title);
		
		_minBuyInLabel = new Label(new Point(0, 0), "Mininum BuyIn ", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		_minBuyInInput = new MoneyInput(new Point(0, 0));
		
		addContent(_minBuyInLabel.getComponent());
		addContent(_minBuyInInput.getComponent());
		
		setSize(260, 160);
		
		addActionToConfirmButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Money minBuyIn = _minBuyInInput.getValue();
				
				if (minBuyIn.parseToLong() > PlayerStats.Instance().getMoney().parseToLong()) {
					_messagePopUp = new MessagePopUp(owner, "BuyIn wrong!", "The most money that you have is " + PlayerStats.Instance().getMoney().toString());
					_messagePopUp.setVisible(true);
				}
				else {
					setVisible(false);
					PlayerStats.Instance().getMoney().removeMoney(minBuyIn);
					PlayerInfo.Instance().getMoneyPlayer().addMoney(minBuyIn);
				}
			}
			
		});
	}

}
