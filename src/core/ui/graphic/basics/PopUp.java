package core.ui.graphic.basics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6190610570846831747L;

	private JButton _confirmButton;
	private JButton _cancelButton;
	private JPanel _buttonPanel;
	private JPanel _messagePanel;
	protected JPanel _mainPanel;
	
	public PopUp(JFrame owner, String title, String message, ActionListener action) {
		super(owner, title, false);
		
		_messagePanel = new JPanel();
		_messagePanel.add(new JLabel(message));
		
		_confirmButton = new JButton("Yes");
		_cancelButton = new JButton("No");
		_buttonPanel = new JPanel();
		_buttonPanel.add(_confirmButton);
		_buttonPanel.add(_cancelButton);
		
		_mainPanel = new JPanel(new BorderLayout());
		_mainPanel.add(_messagePanel, BorderLayout.CENTER);
		_mainPanel.add(_buttonPanel, BorderLayout.SOUTH);
		
		add(_mainPanel);
		pack();
		setLocationRelativeTo(owner);
		setResizable(false);
		setAlwaysOnTop(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		ActionListener hideAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		};
		_confirmButton.addActionListener(action);
		_confirmButton.addActionListener(hideAction);
		_cancelButton.addActionListener(hideAction);
	}
	
	public void addActionToConfirmButton(ActionListener action) {
		_confirmButton.addActionListener(action);
	}
	
	public void setMessage(String message) {
		((JLabel)_messagePanel.getComponent(0)).setText(message);
	}
}
