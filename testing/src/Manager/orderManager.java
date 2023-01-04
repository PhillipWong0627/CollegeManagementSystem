package Manager;

import java.util.Map;

import Entity.Order;
import core.OrderSource;

public class orderManager implements IManager<Order> {

	@Override
	public void create(String id, Order object) {
		
		if(OrderSource.ORDERSOURCE.get(id) ==null) {
			OrderSource.ORDERSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID Already Exist...");
		}
		
	}

	@Override
	public void remove(String id) {
		if(OrderSource.ORDERSOURCE.get(id) !=null ) {
			OrderSource.ORDERSOURCE.remove(id);
		}else {
			throw new IllegalArgumentException("ID Not Exist...");
		}		
	}

	@Override
	public void update(String id, Order object) {
		if(OrderSource.ORDERSOURCE.get(id) !=null ) {
			OrderSource.ORDERSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID Not Exist...");
		}			
	}

	@Override
	public Map<String, Order> getAll() {
		return OrderSource.ORDERSOURCE;
	}

}
