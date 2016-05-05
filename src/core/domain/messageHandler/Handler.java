package core.domain.messageHandler;

import java.util.List;

public abstract class Handler {

	public abstract void handle(List<Object> content);
}
