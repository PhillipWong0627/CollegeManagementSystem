package Manager;

import java.util.Map;

public interface IManager <T> {
	public void create(String id, T object);
	public void remove(String id);
	public void update(String id, T object);

	
	public Map<String, T> getAll();
}
