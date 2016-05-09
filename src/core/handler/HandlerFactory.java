package core.handler;

import java.util.HashMap;
import java.util.Map;

import core.handler.handlerClient.RequestID_RET;
import core.handler.handlerClient.CreateRoomRET;
import core.handler.handlerClient.EchoRET;
import core.handler.handlerClient.GetRoomsRET;

public class HandlerFactory {

	private Map<String, Handler> _tableOfHandler;
	
	public HandlerFactory() {
		_tableOfHandler = new HashMap<String, Handler>();
		
		_tableOfHandler.put("DISCONNECT", new DisconnectHandler());
		//...
		
		_tableOfHandler.put("ECHO_RET", new EchoRET());
		_tableOfHandler.put("CREATE_ROOM_RET", new CreateRoomRET());
		_tableOfHandler.put("GET_ROOM_RET", new GetRoomsRET());
		_tableOfHandler.put("REQUEST_ID_RET", new RequestID_RET());
	}
	
	public Handler getHandlerInstance(String handler) {
		if (!_tableOfHandler.containsKey(handler))
			throw new IllegalArgumentException("This handler not exist in factory");
		
		return _tableOfHandler.get(handler);
	}
}
