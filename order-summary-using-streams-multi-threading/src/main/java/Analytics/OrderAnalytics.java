package Analytics;

import com.greenko.model.Order;
import com.greenko.model.OrderStatus;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderAnalytics {

    // 1. Total revenue for DELIVERED orders
    public static double totalDeliveredRevenue(List<Order> orders) {
        try {
            return orders.stream()
                    .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
                    .mapToDouble(Order::getAmount)
                    .sum();
        } catch (Exception e) {
            System.err.println("Error calculating total delivered revenue: " + e.getMessage());
            return 0.0;
        }
    }

    // 2. Revenue per city (DELIVERED only)
    public static Map<String, Double> revenuePerCity(List<Order> orders) {
        try {
            return orders.stream()
                    .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
                    .collect(Collectors.groupingBy(
                            Order::getCity,
                            Collectors.summingDouble(Order::getAmount)
                    ));
        } catch (Exception e) {
            System.err.println("Error calculating revenue per city: " + e.getMessage());
            return new HashMap<>();
        }
    }

    // 3. Top 3 categories by revenue (DELIVERED only)
    public static Map<String, Double> top3CategoriesByRevenue(List<Order> orders) {
        try {
            return orders.stream()
                    .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
                    .collect(Collectors.groupingBy(
                            Order::getCategory,
                            Collectors.summingDouble(Order::getAmount)
                    ))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            java.util.LinkedHashMap::new
                    ));
        } catch (Exception e) {
            System.err.println("Error calculating top 3 categories by revenue: " + e.getMessage());
            return new HashMap<>();
        }
    }
}