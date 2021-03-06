package nz.ac.victoria.ecs.kpsmart.reporting;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import nz.ac.victoria.ecs.kpsmart.entities.state.Location;
import nz.ac.victoria.ecs.kpsmart.entities.state.Priority;
import nz.ac.victoria.ecs.kpsmart.integration.TimeCapable;

/**
 * Defines the reporting functionality of the system
 * 
 * @author hodderdani
 *
 */
public interface Report extends TimeCapable<Report> {
	/**
	 * Get the total number, total weight, and total volume of all mail sent between every pair of
	 * locations. This does not filter out routes for which there is no mail.
	 * 
	 * @return	All the information about aggregate mail deliveries for every ({@link Location}, {@link Location}) pair.
	 */
	public Collection<AmountOfMail> getAmountsOfMailForAllRoutes();
	
	/**
	 * Get all the revenue and expenditure information for every 
	 * (Source : {@link Location}, Destination : {@link Location}, Priority : {@link Priority }) triple. This does not
	 * filter out triples for which there is no mail
	 * 
	 * @return	All the information about revenue and expenditure.
	 */
	public Collection<DeliveryRevenueExpediture> getAllRevenueExpenditure();
	
	/**
	 * Get the number of events since the initialization of the system.
	 * 
	 * @return	The total number of events
	 */
	public int getNumberOfEvents();
	
	/**
	 * Get the total expenditure.
	 * 
	 * @return	The total amount of money spent by KPS
	 */
	public double getTotalExpenditure();
	
	/**
	 * Get the total revenue of KPS
	 * 
	 * @return	The total revenue
	 */
	public double getTotalRevenue();
	
	/**
	 * Get the revenue/expenditure over time
	 * 
	 * @return a list of RevenueExpendature
	 */
	public List<RevenueExpenditure> getRevenueExpenditureOverTime();
	
	/**
	 * Get the last lastN number of revenue/expenditure over time
	 * 
	 * @param lastN the number of values to return
	 * @return a list of RevenueExpendature
	 */
	public List<RevenueExpenditure> getLastRevenueExpenditureOverTime(int lastN);
	
	/**
	 * Represents the amount of mail for a given source-destination pair.
	 * 
	 * @author hodderdani
	 *
	 */
	public static final class AmountOfMail {
		/**
		 * The start point
		 */
		private final Location startPoint;
		
		/**
		 * The end point
		 */
		private final Location endPoint;
		
		/**
		 * The total number of items transfered over the route.
		 */
		private final int items;
		
		/**
		 * The total weight of items transfered over the route
		 */
		private final double totalWeight;
		
		/**
		 * The total volume of items transfered over the route
		 */
		public final double totalVolume;
		
		public AmountOfMail(Location start, Location end, int items, double weight, double volume) {
			this.startPoint = start;
			this.endPoint = end;
			this.items = items;
			this.totalWeight = weight;
			this.totalVolume = volume;
		}

		@Override
		public String toString() {
			return "AmountOfMail [StartPoint=" + startPoint + ", EndPoint="
					+ endPoint + ", Items=" + items + ", TotalWeight="
					+ totalWeight + ", TotalVolume=" + totalVolume + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((endPoint == null) ? 0 : endPoint.hashCode());
			result = prime * result + items;
			result = prime * result
					+ ((startPoint == null) ? 0 : startPoint.hashCode());
			long temp;
			temp = Double.doubleToLongBits(totalVolume);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(totalWeight);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AmountOfMail other = (AmountOfMail) obj;
			if (endPoint == null) {
				if (other.endPoint != null)
					return false;
			} else if (!endPoint.equals(other.endPoint))
				return false;
			if (items != other.items)
				return false;
			if (startPoint == null) {
				if (other.startPoint != null)
					return false;
			} else if (!startPoint.equals(other.startPoint))
				return false;
			if (Double.doubleToLongBits(totalVolume) != Double
					.doubleToLongBits(other.totalVolume))
				return false;
			if (Double.doubleToLongBits(totalWeight) != Double
					.doubleToLongBits(other.totalWeight))
				return false;
			return true;
		}

		public Location getStartPoint() {
			return startPoint;
		}

		public Location getEndPoint() {
			return endPoint;
		}

		public int getItems() {
			return items;
		}

		public double getTotalWeight() {
			return totalWeight;
		}

		public double getTotalVolume() {
			return totalVolume;
		}
	}
	
	/**
	 * Represents the total revenue and expenditure of a given ({@link Location}, {@link Location}, {@link Priority}) tripple.
	 * 
	 * @author hodderdani
	 *
	 */
	public static final class DeliveryRevenueExpediture {
		/**
		 * The start point
		 */
		private final Location startPoint;
		
		/**
		 * The end point
		 */
		private final Location endPoint;
		
		/**
		 * The priority
		 */
		private final Priority priority;
		
		/**
		 * The revenue generated from this route
		 */
		private final double revenue;
		
		/**
		 * The expenditure generated from this route
		 */
		private final double expenditure;
		
		/**
		 * The average delivery time of mail for this route (in hours)
		 */
		private final double averageDeliveryTime;
		
		public DeliveryRevenueExpediture(Location start, Location end, Priority priority, double revenue, double expenditure, double averageDeliveryTime) {
			this.startPoint = start;
			this.endPoint = end;
			this.priority = priority;
			this.revenue = revenue;
			this.expenditure = expenditure;
			this.averageDeliveryTime = averageDeliveryTime;
		}

		@Override
		public String toString() {
			return "DeliveryRevenueExpediture [StartPoint=" + startPoint
					+ ", EndPoint=" + endPoint + ", Priority=" + priority
					+ ", Revenue=" + revenue + ", Expenditure=" + expenditure
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((endPoint == null) ? 0 : endPoint.hashCode());
			long temp;
			temp = Double.doubleToLongBits(expenditure);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result
					+ ((priority == null) ? 0 : priority.hashCode());
			temp = Double.doubleToLongBits(revenue);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result
					+ ((startPoint == null) ? 0 : startPoint.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DeliveryRevenueExpediture other = (DeliveryRevenueExpediture) obj;
			if (endPoint == null) {
				if (other.endPoint != null)
					return false;
			} else if (!endPoint.equals(other.endPoint))
				return false;
			if (Double.doubleToLongBits(expenditure) != Double
					.doubleToLongBits(other.expenditure))
				return false;
			if (priority != other.priority)
				return false;
			if (Double.doubleToLongBits(revenue) != Double
					.doubleToLongBits(other.revenue))
				return false;
			if (startPoint == null) {
				if (other.startPoint != null)
					return false;
			} else if (!startPoint.equals(other.startPoint))
				return false;
			return true;
		}

		public Location getStartPoint() {
			return startPoint;
		}

		public Location getEndPoint() {
			return endPoint;
		}

		public Priority getPriority() {
			return priority;
		}

		public double getRevenue() {
			return revenue;
		}

		public double getExpenditure() {
			return expenditure;
		}

		public double getAverageDeliveryTime() {
			return averageDeliveryTime;
		}
	}
	
	/**
	 * A revenue/expenditure pair
	 * 
	 * @author ruarusmelb
	 */
	public static final class RevenueExpenditure {
		private final double revenue;
		private final double expenditure;
		private final Date date;
		private final long eventId;
		
		public RevenueExpenditure(double revenue, double expenditure, Date date, long eventId) {
			this.revenue = revenue;
			this.expenditure = expenditure;
			this.date = date;
			this.eventId = eventId;
		}
		
		public double getRevenue() {
			return revenue;
		}
		public double getExpenditure() {
			return expenditure;
		}
		public Date getDate() {
			return date;
		}

		public long getEventId() {
			return eventId;
		}
		
	}
	
	/**
	 * A slice on a donut graph
	 * 
	 * @author ruarusmelb
	 *
	 */
	public static final class GraphSummary {
		private final double y;
		private final double value;
		private final String name;
		
		public GraphSummary(String name, double value, double y) {
			this.name = name;
			this.value = value;
			this.y = y;
		}

		public double getY() {
			return y;
		}

		public double getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
	}
	
	/**
	 * Get the inner circle on the revenue donut graph
	 * @return
	 */
	public List<GraphSummary> getRevenueByDomesticInternational();
	
	/**
	 * Get the inner circle on the expenditure donut graph
	 * @return
	 */
	public List<GraphSummary> getExpenditureByDomesticInternational();
	
	/**
	 * Get the outer circle on the revenue donut graph
	 * @return
	 */
	public List<GraphSummary> getRevenueByRoute();
	
	/**
	 * Get the outer circle on the expenditure donut graph
	 * @return
	 */
	public List<GraphSummary> getExpenditureByRoute();
	
	/**
	 * A summary of a months worth of KPS events
	 * 
	 * @author ruarusmelb
	 *
	 */
	public static final class MonthSummary {
		private final String name;
		private final double revenue;
		private final double expenditure;
		private final long eventCount;
		private final double weight;
		private final double volume;
		
		public MonthSummary(String name, double revenue, double expenditure, long eventCount, double weight, double volume) {
			this.name = name;
			this.revenue = revenue;
			this.expenditure = expenditure;
			this.eventCount = eventCount;
			this.weight = weight;
			this.volume = volume;	
		}

		public double getRevenue() {
			return revenue;
		}

		public double getExpenditure() {
			return expenditure;
		}

		public long getEventCount() {
			return eventCount;
		}

		public double getWeight() {
			return weight;
		}

		public double getVolume() {
			return volume;
		}

		public String getName() {
			return name;
		}
	}
	
	public List<MonthSummary> getMonthlySummary();
}
