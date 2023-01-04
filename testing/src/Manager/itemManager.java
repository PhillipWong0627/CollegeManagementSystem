package Manager;

import java.util.Map;

import Entity.Item;
import core.ItemSource;

public class itemManager implements IManager<Item> {

	@Override
	public void create(String id, Item object) {
		if(ItemSource.ITEMSOURCE.get(id) == null) {
			ItemSource.ITEMSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID already Exist...");
		}
	}

	@Override
	public void remove(String id) {
		if(ItemSource.ITEMSOURCE.get(id) != null) {
			ItemSource.ITEMSOURCE.remove(id);
		}else {
			throw new IllegalArgumentException("ID Not Exist...");
		}		
	}

	@Override
	public void update(String id, Item object) {
		if(ItemSource.ITEMSOURCE.get(id) != null) {
			ItemSource.ITEMSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID Not Exist...");
		}				
	}

	@Override
	public Map<String, Item> getAll() {
		return ItemSource.ITEMSOURCE;
	}

}
