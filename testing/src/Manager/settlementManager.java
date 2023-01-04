package Manager;

import java.util.Map;

import Entity.Settlement;
import core.SettlementSource;

public class settlementManager implements IManager<Settlement> {

	@Override
	public void create(String id, Settlement object) {

		if(SettlementSource.SETTLEMENTSOURCE.get(id) == null) {
			SettlementSource.SETTLEMENTSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID already Exist...");
		}
		
	}

	@Override
	public void remove(String id) {
		if(SettlementSource.SETTLEMENTSOURCE.get(id) != null) {
			SettlementSource.SETTLEMENTSOURCE.remove(id);
		}else {
			throw new IllegalArgumentException("ID Not Exist...");
		}		
	}

	@Override
	public void update(String id, Settlement object) {
		if(SettlementSource.SETTLEMENTSOURCE.get(id) != null) {
			SettlementSource.SETTLEMENTSOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("ID Not Exist...");
		}		
	}

	@Override
	public Map<String, Settlement> getAll() {
		return SettlementSource.SETTLEMENTSOURCE;
	}

}
