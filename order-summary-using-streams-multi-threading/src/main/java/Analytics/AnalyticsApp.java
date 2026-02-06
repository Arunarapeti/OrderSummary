package Analytics;



import java.util.List;

import com.greenko.model.Order;
import com.greenko.model.OrderStatus;

public class AnalyticsApp {

    public static void main(String[] args) throws Exception {

        List<Order> orders = List.of(
                new Order("101", "C1", "Mobiles", 500.0, "Mumbai", OrderStatus.PLACED),
                new Order("102", "C2", "Bottles", 1550.0, "HYD", OrderStatus.DELIVERED),
                new Order("103", "C3", "Books", 2000.0, "Bangalore", OrderStatus.DELIVERED),
                new Order("104", "C4", "Electronics", 2000.0, "Chennai", OrderStatus.CANCELLED),
                new Order("105", "C5", "Tables", 2500.0, "Goa", OrderStatus.DELIVERED),
                new Order("106", "C6", "Assets", 6000.0, "Mysore", OrderStatus.DELIVERED),
                new Order("107", "C7", "Bags", 2500.0, "Goa", OrderStatus.DELIVERED),
                new Order("108", "C8", "Laptops", 2500.0, "Delhi", OrderStatus.DELIVERED),
                new Order("109", "C9", "Phones", 2500.0, "UK", OrderStatus.CANCELLED),
                new Order("110", "C10", "CD", 2500.0, "France", OrderStatus.DELIVERED),
                new Order("111", "C11", "Mouse", 2500.0, "China", OrderStatus.CANCELLED)
        );

        System.out.println("=== Milestone 1 ===");
        System.out.println("Total Revenue: " +
                OrderAnalytics.totalDeliveredRevenue(orders));
        System.out.println("Revenue per City: " +
                OrderAnalytics.revenuePerCity(orders));
        System.out.println("Top 3 Categories: " +
                OrderAnalytics.top3CategoriesByRevenue(orders));

        System.out.println("\n=== Milestone 2 (Parallel) ===");
        ParallelOrderAnalytics parallel = new ParallelOrderAnalytics();
        AnalyticsResult result = parallel.computeAll(orders);

        System.out.println("Total Revenue: " + result.getTotalRevenue());
        System.out.println("Revenue per City: " + result.getRevenuePerCity());
        System.out.println("Top 3 Categories: " + result.getTopCategories());
    }
}
