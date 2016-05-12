package core.storage;

public interface Storage {

	boolean exist(String filePath);
	<T> T load(String filePath, Class<T> type);
	void save(String filePath, Object object);
}
