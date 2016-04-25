package core.storage;

import com.google.gson.Gson;

public class JSON_File implements Storage {

	private static JSON_File _instance = null;
	private Gson _gson;
	
	private JSON_File() {
		_gson = new Gson();
	}
	
	public static synchronized JSON_File Instance() {
		if (_instance == null)
			_instance = new JSON_File();
		return _instance;
	}
	
	@Override
	public boolean exist(String filePath) {
		return false;
	}

	@Override
	public <T> T load(String filePath, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String file, Object object) {
		// TODO Auto-generated method stub

	}

}
