package core.handler.handlerClient;

import java.util.List;

import core.handler.Handler;

public class EchoRET extends Handler {

	@Override
	public void handle(List<Object> content) {
		System.out.println(_gson.fromJson((String)content.get(2), String.class));
	}
}
