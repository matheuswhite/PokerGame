package core.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class JSON_File implements Storage {

	private static JSON_File _instance = null;
	private Gson _gson;
	private BufferedReader _reader;
	private BufferedWriter _writer;
	
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
		File file = new File(filePath);
		return file.exists();
	}

	@Override
	public <T> T load(String filePath, Class<T> type) {
		String jsonString = null;
		
		try {
			_reader = new BufferedReader(new FileReader(filePath));
			jsonString = _reader.readLine();
			_reader.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return _gson.fromJson(jsonString, type);
	}

	@Override
	public void save(String filePath, Object object) {
		try {
			_writer = new BufferedWriter(new FileWriter(filePath));
			_writer.write(_gson.toJson(object));
			_writer.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
