package core.handler.handlerClient;

import java.util.List;

import core.domain.game.Card;
import core.domain.game.MatchInfo;
import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.ui.graphic.screen.MatchScreen;

public class ChangePhase extends Handler {

	@Override
	public void handle(List<Object> content) {
		MatchInfo matchInfo = (MatchInfo) content.get(2);
		MatchScreen matchScreen = (MatchScreen) content.get(1);

		try {
			matchScreen.getRoom().setMatchInfo(matchInfo);
			
			for (PlayerInfo playerInfo : matchScreen.getRoom().getPlayers()) {
				matchScreen.getPlayerGraphicsManager().clearBet(playerInfo.getSeat());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		switch (matchInfo.getCurrentMatchPhase()) {
		case WAIT_PLAYERS:
			handlerWaitPlayers(matchScreen, matchInfo);
			break;
		case PRE_FLOP:
			//START_GAME
			break;
		case FLOP:
			handlerFlop(matchScreen, matchInfo);
			break;
		case TURN:
			handlerTurn(matchScreen, matchInfo);
			break;
		case RIVER:
			handlerRiver(matchScreen, matchInfo);
			break;
		case SHOWDOWN:
			handlerShowdown(matchScreen, matchInfo);
			break;
		default:
			break;
		}
	}

	private void handlerShowdown(MatchScreen matchScreen, MatchInfo matchInfo) {
		try {
			for (PlayerInfo playerInfo : matchScreen.getRoom().getPlayers()) {
				matchScreen.getPlayerGraphicsManager().showCards(playerInfo.getSeat());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handlerRiver(MatchScreen matchScreen, MatchInfo matchInfo) {
		matchScreen.getTableGraphicsManager().addFourthCard(matchInfo.getCardsInTable()[4]);
	}

	private void handlerTurn(MatchScreen matchScreen, MatchInfo matchInfo) {
		matchScreen.getTableGraphicsManager().addFourthCard(matchInfo.getCardsInTable()[3]);
	}

	private void handlerFlop(MatchScreen matchScreen, MatchInfo matchInfo) {
		Card cards[] = new Card[3];
		for (int i = 0; i < 3; i++) {
			cards[i] = matchInfo.getCardsInTable()[i];
		}
		matchScreen.getTableGraphicsManager().addThreeCards(cards);
	}

	private void handlerWaitPlayers(MatchScreen matchScreen, MatchInfo matchInfo) {
		matchScreen.getTableGraphicsManager().clearCards();
		matchScreen.getTableGraphicsManager().clearPot();

		try {
			
			for (PlayerInfo playerInfo : matchScreen.getRoom().getPlayers()) {
				matchScreen.getPlayerGraphicsManager().takeCards(playerInfo.getSeat());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
