package core.net;

import java.util.ArrayList;
import java.util.List;

import core.domain.game.PlayerInfo;
import core.handler.Handler;
import core.handler.HandlerFactory;
import core.ui.graphic.screen.MainScreen;
import core.ui.graphic.screen.MatchScreen;

public class MessageHandler {

	private HandlerFactory _factory;
	private Handler _handler;
	private List<Object> _objects;
	
	private MainScreen _mainScreen;
	private MatchScreen _matchScreen;
	
	public MessageHandler(PlayerInfo playerInfo) {
		_objects = new ArrayList<Object>();
		_factory = new HandlerFactory(playerInfo);
	}
	
	public void setMainScreen(MainScreen mainScreen) {
		_mainScreen = mainScreen;
	}
	
	public void setMatchScreen(MatchScreen matchScreen) {
		_matchScreen = matchScreen;
	}
	
	public void handler(Message message) {
		_handler = _factory.getHandlerInstance(message.getHandler());
		
		_objects.clear();
		_objects.add(_mainScreen);
		_objects.add(_matchScreen);
		_objects.addAll(message.getContents());
		
		_handler.handle(_objects);
	}
}
