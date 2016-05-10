package core.handler;

import java.util.HashMap;
import java.util.Map;

import core.handler.handlerClient.RequestID_RET;
import core.handler.handlerClient.StartGameHandler;
import core.handler.handlerClient.WinnerHandler;
import core.handler.handlerClient.BuyInHandler;
import core.handler.handlerClient.CallHandler;
import core.handler.handlerClient.ChangePhase;
import core.handler.handlerClient.CreateRoomRET;
import core.handler.handlerClient.EchoRET;
import core.handler.handlerClient.EndTurnHandler;
import core.handler.handlerClient.FoldHandler;
import core.handler.handlerClient.GetRoomsRET;
import core.handler.handlerClient.JoinHandler;
import core.handler.handlerClient.LeaveHandler;
import core.handler.handlerClient.RaiseHandler;

public class HandlerFactory {

	private Map<String, Handler> _tableOfHandler;
	
	public HandlerFactory() {
		_tableOfHandler = new HashMap<String, Handler>();
		
		_tableOfHandler.put("DISCONNECT", new DisconnectHandler());
		_tableOfHandler.put("END_TURN", new EndTurnHandler());
		_tableOfHandler.put("CALL", new CallHandler());
		_tableOfHandler.put("FOLD", new FoldHandler());
		_tableOfHandler.put("RAISE", new RaiseHandler());
		_tableOfHandler.put("BUY_IN", new BuyInHandler());
		_tableOfHandler.put("START_GAME", new StartGameHandler());
		_tableOfHandler.put("JOIN", new JoinHandler());
		_tableOfHandler.put("LEAVE", new LeaveHandler());
		_tableOfHandler.put("CHANGE_PHASE", new ChangePhase());
		_tableOfHandler.put("WINNER", new WinnerHandler());
		
		_tableOfHandler.put("ECHO_RET", new EchoRET());
		_tableOfHandler.put("CREATE_ROOM_RET", new CreateRoomRET());
		_tableOfHandler.put("GET_ROOMS_RET", new GetRoomsRET());
		_tableOfHandler.put("REQUEST_ID_RET", new RequestID_RET());
	}
	
	public Handler getHandlerInstance(String handler) {
		if (!_tableOfHandler.containsKey(handler))
			throw new IllegalArgumentException("This handler not exist in factory");
		
		return _tableOfHandler.get(handler);
	}
}
