package nz.ac.victoria.ecs.kpsmart.state;

import java.util.Collection;
import java.util.List;

import nz.ac.victoria.ecs.kpsmart.entities.state.Carrier;
import nz.ac.victoria.ecs.kpsmart.entities.state.CustomerPrice;
import nz.ac.victoria.ecs.kpsmart.entities.state.DomesticCustomerPrice;
import nz.ac.victoria.ecs.kpsmart.entities.state.Location;
import nz.ac.victoria.ecs.kpsmart.entities.state.MailDelivery;
import nz.ac.victoria.ecs.kpsmart.entities.state.Price;
import nz.ac.victoria.ecs.kpsmart.entities.state.Priority;
import nz.ac.victoria.ecs.kpsmart.entities.state.Route;
import nz.ac.victoria.ecs.kpsmart.entities.state.TransportMeans;
import nz.ac.victoria.ecs.kpsmart.integration.TimeCapable;

/**
 * Defines read only aspects of a state manipulator
 * 
 * @author hodderdani
 *
 */
public interface ReadOnlyState extends TimeCapable<ReadOnlyState> {
	/**
	 * Get a mail delivery by it's id
	 * 
	 * @param id	The ID of the mail delivery
	 * @return	The referenced mail delivery, or null if none matched the id.
	 */
	public MailDelivery getMailDelivery(final long id);
	
	/**
	 * Get all the locations in the datasource.
	 * 
	 * @return	All the locations known to this state. The order is undefined.
	 */
	public Collection<Location> getAllLocations();
	
	/**
	 * Get a location by it's unique name
	 * 
	 * @param name	The unique name of the location
	 * @return	The location or null if none matched.
	 */
	public Location getLocationForName(final String name);
	
	/**
	 * Get all the routes in the datasource, ordered by the unique id
	 * 
	 * @return	The list of routes.
	 */
	public List<Route> getAllRoute();
	
	/**
	 * Get all the routes applicable for the given priority.
	 * 
	 * @param priority	The priority to use
	 * @return	The collection of all routes for this priority
	 */
	public Collection<Route> getAllRoutesForPriority(Priority priority);
	
	/**
	 * Get all the routes with one of, either the start or end, points at the given location
	 * 
	 * @param location	The location which the route should originate from, or end at.
	 * @return	A collection of routes matching the criteria. Order is not guaranteed.
	 */
//	public Collection<Route> getAllRoutesWithPoint(Location location);
	
	/**
	 * Get all routes starting at the given location
	 * 
	 * @param location	The location to start at
	 * @return	A collection of every route starting at the given location
	 */
//	public Collection<Route> getAllRoutesStartAt(Location location);
	
	/**
	 * Get all the routes that start at the start point, end at the end point, and are applicable for the given priority.
	 * 
	 * @param start	The start point.
	 * @param end	The end point.
	 * @param priority	The priority to search for
	 * @return	All the routes that match the criteria
	 */
	public Collection<Route> getRoutesBetween(Location start, Location end, Priority priority);
	
	/**
	 * Get a route by it's unique ID
	 * 
	 * @param id	The ID of the route
	 * @return	The route identified by this id, or null if no route was found.
	 */
	public Route getRouteByID(long id);
	
	/**
	 * Get a route by it's unique key
	 * 
	 * @param startPoint	The start point of the route
	 * @param endPoint	The end point of the route
	 * @param transport	The transport means the route uses
	 * @param carrier	The carrier who carries mail on this route
	 * @return	The route or null if none was found.
	 */
	public Route getRouteByKey(Location startPoint, Location endPoint, TransportMeans transport, Carrier carrier);
	
	/**
	 * Get a carrier by it's unique ID
	 * 
	 * @param id	The ID of the carrier
	 * @return	The carrier requested, or null if none found
	 */
	public Carrier getCarrier(final long id);
	
	/**
	 * Get all the carriers known to the datasource.
	 * 
	 * @return	A collection of the carriers. Order is not guaranteed.
	 */
	public Collection<Carrier> getAllCarriers();
	
	/**
	 * Get the domestic customer price for the given priority
	 * 
	 * @param priority	The priority to get the price for
	 * @return	The domestic customer price
	 */
	public DomesticCustomerPrice getDomesticCustomerPrice(Priority priority);
	
	/**
	 * Get all the customer price information in the datasource.
	 * 
	 * @return	All the customer prices known to the datasource. Order is not guaranteed.
	 */
	public Collection<CustomerPrice> getAllCustomerPrices();
	
	/**
	 * Get the customer price for the given ({@link Location}, {@link Location}, {@link Priority}) triple.
	 * 
	 * @param start	The start point
	 * @param end	The end point
	 * @param priority	The priority
	 * @return	The price charged for this route
	 */
	public CustomerPrice getCustomerPrice(Location start, Location end, Priority priority);
	
	/**
	 * Get the price for the given ({@link Location}, {@link Location}, {@link Priority}) triple.
	 * 
	 * @param start	The start point
	 * @param end	The end point
	 * @param priority	The priority
	 * @return	The price charged for this route
	 */
	public Price getPrice(Location start, Location end, Priority priority);
	
	/**
	 * Get all the mail deliveries known to the datasource
	 * 
	 * @return	The mail deliveries
	 */
	public Collection<MailDelivery> getAllMailDeliveries();
	

	/**
	 * Get a carrier by it's unique name
	 * 
	 * @param name	The name of the carrier
	 * @return	The carrier or null if none was found
	 */
	public Carrier getCarrier(String name);

	/**
	 * Get a customer price by its ID
	 * 
	 * @param id the id of the customer price
	 * @return
	 */
	public CustomerPrice getCustomerPriceById(long id);

	/** Get all the routes which have location as one of their end points
	 * 
	 * @param location the location which is one of the end points
	 * @return a list of routes with location as one of the end points
	 */
	public List<Route> getRoutesConnectedTo(Location location);
}
