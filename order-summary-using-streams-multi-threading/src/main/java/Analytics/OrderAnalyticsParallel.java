package Analytics;


import com.greenko.model.Order;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class OrderAnalyticsParallel {

    public static void runAnalyticsInParallel(List<Order> orders)
            throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Double> totalRevenueTask =
                () -> OrderAnalytics.totalDeliveredRevenue(orders);

        Callable<Map<String, Double>> revenuePerCityTask =
                () -> OrderAnalytics.revenuePerCity(orders);

        Callable<Map<String, Double>> topCategoriesTask =
                () -> OrderAnalytics.top3CategoriesByRevenue(orders);

        Future<Double> totalRevenueFuture = executor.submit(totalRevenueTask);
        Future<Map<String, Double>> cityRevenueFuture = executor.submit(revenuePerCityTask);
        Future<Map<String, Double>> topCategoriesFuture = executor.submit(topCategoriesTask);

        System.out.println("Total Delivered Revenue: " + totalRevenueFuture.get());
        System.out.println("Revenue Per City: " + cityRevenueFuture.get());
        System.out.println("Top 3 Categories: " + topCategoriesFuture.get());

        executor.shutdown();
    }
}