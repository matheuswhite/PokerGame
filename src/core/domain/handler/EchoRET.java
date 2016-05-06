package core.domain.handler;

import java.util.List;

public class EchoRET extends Handler {
	
	@Override
	public void handle(List<Object> content) {
		System.out.println(content.get(2));
	}
}
