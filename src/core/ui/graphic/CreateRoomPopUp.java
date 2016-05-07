package core.ui.graphic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import core.domain.action.CreateRoomAction;
import core.domain.game.Money;
import core.domain.game.PlayerInfo;
import core.domain.game.PlayerStats;
import core.ui.graphic.basics.Label;
import core.ui.graphic.basics.PopUp;
import core.ui.graphic.basics.TextStyle;
import core.ui.input.MoneyInput;

public class CreateRoomPopUp extends PopUp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7327584737147532737L;
	
	private Label _minBuyInLabel;
	private MoneyInput _minBuyInInput;
	
	private Label _smallBlindLabel;
	private MoneyInput _smallBlindInput;
	
	private MessagePopUp _messagePopUp;
	private CreateRoomAction _createRoomAction;
	
	public CreateRoomPopUp(JFrame owner, String title) {
		super(owner, title);
		
		_minBuyInLabel = new Label(new Point(0, 0), "Mininum BuyIn ", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		_minBuyInInput = new MoneyInput(new Point(0, 0));
		
		_smallBlindLabel = new Label(new Point(0, 20), "SmallBlind ", new TextStyle(Color.BLACK, "Arial", 12, false, false));
		_smallBlindInput = new MoneyInput(new Point(0, 20));
		
		_createRoomAction = new CreateRoomAction();
		
		addContent(_minBuyInLabel.getComponent());
		addContent(_minBuyInInput.getComponent());
		
		addContent(_smallBlindLabel.getComponent());
		addContent(_smallBlindInput.getComponent());
		
		setSize(260, 160);
		
		addActionToConfirmButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Money minBuyIn = _minBuyInInput.getValue();
				Money smallBlind = _smallBlindInput.getValue();
				
				if (smallBlind.parseToLong() < 50) {
					_messagePopUp = new MessagePopUp(owner, "SmallBlind wrong!", "The SmallBlind must be greater than 50");
					_messagePopUp.setVisible(true);
				}
				else if (minBuyIn.parseToLong() > PlayerStats.Instance().getMoney().parseToLong()) {
					_messagePopUp = new MessagePopUp(owner, "BuyIn wrong!", "The most money that you have is " + PlayerStats.Instance().getMoney().toString());
					_messagePopUp.setVisible(true);
				}
				else {
					setVisible(false);
					owner.setVisible(false);
					
					PlayerStats.Instance().getMoney().removeMoney(minBuyIn);
					PlayerStats.Instance().getMoney().toString();
					PlayerInfo.Instance().setMoneyPlayer(minBuyIn);
					
					_createRoomAction.actionPerformed(null);
				}
			}
			
		});
	}

}
