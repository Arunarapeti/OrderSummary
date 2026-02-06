package Analytics;

import java.util.*;
import java.util.stream.Collectors;

import com.greenko.model.Order;
import com.greenko.model.OrderStatus;

public class OrderAnalytics {

    // Total revenue of DELIVERED orders
    public static double totalDeliveredRevenue(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
                .mapToDouble(Order::getAmount)
                .sum();
    }

    // Revenue per city (DELIVERED only)
    public static Map<String, Double> revenuePerCity(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
                .collect(Collectors.groupingBy(
                        Order::getCity,
                        Collectors.summingDouble(Order::getAmount)
                ));
    }

    // Top 3 categories by revenue (DELIVERED only)
    public static List<String> top3CategoriesByRevenue(List<Order> orders) {

        Map<String, Double> revenueByCategory =
                orders.stream()
                        .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
                        .collect(Collectors.groupingBy(
                                Order::getCategory,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        return revenueByCategory.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
