package core.ui.graphic.graphicsManager;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import core.domain.Card;
import core.domain.Money;
import core.domain.PlayerInfo;
import core.ui.graphic.BetTokenImage;
import core.ui.graphic.HandImage;
import core.ui.graphic.Image;
import core.ui.graphic.PlayerInfoImage;
import core.ui.graphic.Window;

public class PlayersGraphicsManager {
	
	private Image[] _emptySeatsImages;
	private HandImage[] _handsImages;
	private PlayerInfoImage[] _infoImages;
	private BetTokenImage[] _betTokenImages;
	private Image[] _dealerImages;
	
	private List<PlayerInfo> _playerInfos;
	private int _dealer;
	
	public PlayersGraphicsManager(Window window, PlayerInfo player1) {
		_playerInfos = new ArrayList<PlayerInfo>(6);
		_playerInfos.add(player1);
		
		_dealer = -1;
		
		addDealerImages(window);
		addPlayerInfoImages(window);
		addHandImages(window);
		addEmptySeatImages(window);
		addBetTokenImages(window);
	}
	
	
	public void addPlayer(PlayerInfo player) throws Exception {
		for (int i = 0; i < 6; i++) {
			if (_playerInfos.get(i) == null) 
			{
				_playerInfos.add(i, player);
				player.setSeat(i);
				
				_emptySeatsImages[i].hide();
				_infoImages[i].setInfos(player);
				_infoImages[i].show();
			}
		}
		throw new Exception("All seats already were occupied!");
	}
	public void removePlayer(int seat) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("This seat already is empty");
		
		if (seat == _dealer)
			setNextDealer();
		_playerInfos.remove(seat);
		
		_emptySeatsImages[seat].show();
		_infoImages[seat].hide();
	}


	public void giveCards(int seat, Card card1, Card card2) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("Without player in this seat");
		
		_handsImages[seat].setCards(card1, card2);
		_handsImages[seat].show();
	}
	public void showCards(int seat) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("Without player in this seat");
		
		_handsImages[seat].flipCard();
	}
	public void takeCards(int seat) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("Without player in this seat");
		
		_handsImages[seat].hide();
	}
	
	
	public void bet(int seat, Money money) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("Without player in this seat");
		
		_betTokenImages[seat].addMoney(money);
		_betTokenImages[seat].show();
	}
	public void clearBet(int seat) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("Without player in this seat");
		
		_betTokenImages[seat].hide();
		_betTokenImages[seat].clearMoney();
	}
	
	
	public void setDealer(int seat) throws Exception {
		if (_playerInfos.get(seat) == null)
			throw new Exception("Without player in this seat");
		
		_dealerImages[_dealer].hide();
		_dealerImages[seat].show();
	}
	public void setNextDealer() {
		int currentSeat = _dealer;
		
		for (int i = 0; i < 6; i++) {
			currentSeat = (currentSeat == 6) ? 1 : currentSeat + 1;
			
			if (_playerInfos.get(currentSeat) != null) {
				_dealerImages[_dealer].hide();
				_dealer = currentSeat;
				_dealerImages[_dealer].show();
			}
		}
	}
	
	
	private void addEmptySeatImages(Window window) {
		_emptySeatsImages = new Image[6];
		
		_emptySeatsImages[0] = new Image(new Rectangle(750, 210, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[1] = new Image(new Rectangle(530, 370, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[2] = new Image(new Rectangle(220, 370, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[3] = new Image(new Rectangle(10, 210, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[4] = new Image(new Rectangle(220, 60, 117, 117), "src/imgs/emptySeat");
		_emptySeatsImages[5] = new Image(new Rectangle(530, 60, 117, 117), "src/imgs/emptySeat");
		
		for (int i = 0; i < _emptySeatsImages.length; i++) {
			_emptySeatsImages[i].resize(0.8, false);
			window.addComponent(_emptySeatsImages[i]);
		}
	}
	private void addHandImages(Window window) {
		_handsImages = new HandImage[6];
		
		_handsImages[0] = new HandImage(window, new Point(720, 195));
		_handsImages[1] = new HandImage(window, new Point(540, 365));
		_handsImages[2] = new HandImage(window, new Point(200, 365));
		_handsImages[3] = new HandImage(window, new Point(20, 195));
		_handsImages[4] = new HandImage(window, new Point(230, 45));
		_handsImages[5] = new HandImage(window, new Point(520, 45));
	}
	private void addPlayerInfoImages(Window window) {
		_infoImages = new PlayerInfoImage[6];
		
		_infoImages[0] = new PlayerInfoImage(window, new Point(710, 265));
		_infoImages[1] = new PlayerInfoImage(window, new Point(530, 435));
		_infoImages[2] = new PlayerInfoImage(window, new Point(190, 435));
		_infoImages[3] = new PlayerInfoImage(window, new Point(10, 265));
		_infoImages[4] = new PlayerInfoImage(window, new Point(220, 115));
		_infoImages[5] = new PlayerInfoImage(window, new Point(510, 115));
	}
	private void addBetTokenImages(Window window) {
		_betTokenImages = new BetTokenImage[6];

		_betTokenImages[0] = new BetTokenImage(window, new Point(605, 220));
		_betTokenImages[1] = new BetTokenImage(window, new Point(550, 325));
		_betTokenImages[2] = new BetTokenImage(window, new Point(210, 325));
		_betTokenImages[3] = new BetTokenImage(window, new Point(130, 220));
		_betTokenImages[4] = new BetTokenImage(window, new Point(230, 165));
		_betTokenImages[5] = new BetTokenImage(window, new Point(520, 165));
	}
	private void addDealerImages(Window window) {
		int width = 34;
		int height = 28;
		String filePath = "src/imgs/dealerToken";
		
		_dealerImages = new Image[6];
		
		_dealerImages[0] = new Image(new Rectangle(800, 270, width, height), filePath);
		_dealerImages[1] = new Image(new Rectangle(640, 440, width, height), filePath);
		_dealerImages[2] = new Image(new Rectangle(280, 440, width, height), filePath);
		_dealerImages[3] = new Image(new Rectangle(100, 270, width, height), filePath);
		_dealerImages[4] = new Image(new Rectangle(310, 120, width, height), filePath);
		_dealerImages[5] = new Image(new Rectangle(600, 120, width, height), filePath);
		
		for (int i = 0; i < _dealerImages.length; i++) {
			_dealerImages[i].hide();
			window.addComponent(_dealerImages[i]);
		}
	}
}
