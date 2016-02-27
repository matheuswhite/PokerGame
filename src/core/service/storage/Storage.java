package core.service.storage;

public interface Storage<K, V> {

	void insert(V data);
	V consult(K key);
	void change(V data, K key);
	void delete(K key);
}
