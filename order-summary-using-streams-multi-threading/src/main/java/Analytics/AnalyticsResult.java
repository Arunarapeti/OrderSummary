package Analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsResult {

    private final double totalRevenue;
    private final Map<String, Double> revenuePerCity;
    private final List<String> topCategories;

    public AnalyticsResult(double totalRevenue,
                           Map<String, Double> revenuePerCity,
                           List<String> topCategories) {
        this.totalRevenue = totalRevenue;
        this.revenuePerCity = revenuePerCity;
        this.topCategories = topCategories;
    }

    public AnalyticsResult(Double totalRevenue2, Map<String, Double> revenuePerCity2, List<String> topCategories2) {
		this.totalRevenue = 0;
		this.revenuePerCity = null;
		// TODO Auto-generated constructor stub
		this.topCategories = null;
	}

	public double getTotalRevenue() {
        return totalRevenue;
    }

    public Map<String, Double> getRevenuePerCity() {
        return revenuePerCity;
    }

    public List<String> getTopCategories() {
        return topCategories;
    }
}
