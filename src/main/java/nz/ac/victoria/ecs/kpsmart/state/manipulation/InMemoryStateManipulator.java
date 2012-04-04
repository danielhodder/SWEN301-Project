/**
 * 
 */
package nz.ac.victoria.ecs.kpsmart.state.manipulation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import nz.ac.victoria.ecs.kpsmart.state.entities.state.Carrier;
import nz.ac.victoria.ecs.kpsmart.state.entities.state.DomesticCustomerPrice;
import nz.ac.victoria.ecs.kpsmart.state.entities.state.Location;
import nz.ac.victoria.ecs.kpsmart.state.entities.state.MailDelivery;
import nz.ac.victoria.ecs.kpsmart.state.entities.state.Priority;
import nz.ac.victoria.ecs.kpsmart.state.entities.state.Route;
import nz.ac.victoria.ecs.kpsmart.state.entities.state.StorageEntity;

/**
 * @author hodderdani
 *
 */
public final class InMemoryStateManipulator implements StateManipulator {
	private final Map<Long, MailDelivery> mailDeliveries = new HashMap<Long, MailDelivery>();
	private final Collection<Location> locations = new HashSet<Location>();
	
	@Override
	public MailDelivery getMailDelivery(long id) {
		return mailDeliveries.get(id);
	}

	@Override
	public void saveMailDelivery(MailDelivery delivery) {
		this.mailDeliveries.put(delivery.getId(), delivery);
	}

	@Override
	public Collection<Location> getAllLocations() {
		return locations;
	}

	@Override
	public List<Route> getAllRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRoute(Route route) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carrier getCarrier(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCarrier(StorageEntity carier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location getLocationForName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLocation(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Carrier> getAllCarriers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCarrier(StorageEntity carrier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Route getRouteByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoute(Route route) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(StorageEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StorageEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DomesticCustomerPrice getDomesticCustomerPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DomesticCustomerPrice domesticPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Route> getAllRoutesForPriority(Priority priority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Route> getRoutesBetween(Location start, Location end,
			Priority priority) {
		// TODO Auto-generated method stub
		return null;
	}

}
