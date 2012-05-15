package nz.ac.victoria.ecs.kpsmart.controller;


import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.ajax.JavaScriptResolution;
import nz.ac.victoria.ecs.kpsmart.integration.EntityManager;
import nz.ac.victoria.ecs.kpsmart.logging.ReadOnlyLog;
import nz.ac.victoria.ecs.kpsmart.reporting.Report;
import nz.ac.victoria.ecs.kpsmart.reporting.Report.DeliveryRevenueExpediture;
import nz.ac.victoria.ecs.kpsmart.reporting.Report.RevenueExpenditure;

@UrlBinding("/dashboard/{$event}")
public class DashboardActionBean extends AbstractActionBean {
	private long atevent = 0;
	private EntityManager manager = super.getEntityManager();
	
	@DefaultHandler
	public Resolution dashboard() {
		return new ForwardResolution("/views/dashboard/dashboard.jsp");
	}
	
	@HandlesEvent("eventcount")
	public Resolution getEventCount() {
		return new JavaScriptResolution(getLog().getNumberOfEvents());
	}
	
	public Report getReportManager() {
		return getEntityManager().getReports();
	}
	
	@Override
	public EntityManager getEntityManager() {
		return manager;
	}
	
	@Override
	public ReadOnlyLog getLog() {
		return super.getEntityManager().getLog();
	}

	public long getAtevent() {
		return atevent;
	}

	public void setAtevent(long atevent) {
		this.atevent = atevent;
		if(atevent == 0) {
			manager = super.getEntityManager();
		}
		else {
			manager = super.getEntityManager().getEntityManagerAtEventPoint(atevent);
		}
	}
	
	public boolean hasCriticalRoutes() {
		for (DeliveryRevenueExpediture re : this.getReportManager().getAllRevenueExpenditure())
			if (re.getExpenditure() > re.getRevenue())
				return true;
		
		return false;
	}
}
