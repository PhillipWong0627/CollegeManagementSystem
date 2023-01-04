package Manager;

import java.util.Map;

import Entity.Cart;
import core.CartSource;

public class cartManager implements IManager<Cart> {

	@Override
	public void create(String id, Cart object) {
		if(CartSource.CARTSOURCE.get(id) == null) {
			CartSource.CARTSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID Exist..");
		}
		
	}

	@Override
	public void remove(String id) {
		if(CartSource.CARTSOURCE.get(id) != null) {
			CartSource.CARTSOURCE.remove(id);

		}else {
			throw new IllegalArgumentException("ID Not exist..");
		}		
	}

	@Override
	public void update(String id, Cart object) {
		if(CartSource.CARTSOURCE.get(id) != null) {
			CartSource.CARTSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID Not exist..");
		}		
	}

	@Override
	public Map<String, Cart> getAll() {
		return CartSource.CARTSOURCE;
	}

}
