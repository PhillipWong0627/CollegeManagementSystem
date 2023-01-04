package Manager;

import java.util.Map;

import Entity.Admin;
import core.AdminSource;

public class adminManager implements IManager<Admin> {

	@Override
	public void create(String id, Admin object) {
		
		if(AdminSource.ADMIN_SOURCE.get(id) == null) {
			AdminSource.ADMIN_SOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("Admin ID Already Exist");
		}
		
	}

	@Override
	public void remove(String id) {
		if(AdminSource.ADMIN_SOURCE.get(id) != null) {
			AdminSource.ADMIN_SOURCE.remove(id);
		}else {
			throw new IllegalArgumentException("Admin ID Not Exist");
		}
	}

	@Override
	public void update(String id, Admin object) {
		if(AdminSource.ADMIN_SOURCE.get(id) != null) {
			AdminSource.ADMIN_SOURCE.put(id, object);
		}else {
			throw new IllegalArgumentException("Admin ID Not Exist");
		}		
	}

	@Override
	public Map<String, Admin> getAll() {
		return AdminSource.ADMIN_SOURCE;
	}

}
