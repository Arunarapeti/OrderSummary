package Analytics;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import com.greenko.model.Order;

public class ParallelOrderAnalytics {

    private static final ExecutorService executor =
            Executors.newFixedThreadPool(3);

    public AnalyticsResult computeAll(List<Order> orders) throws Exception {

        CompletableFuture<Double> totalRevenueFuture =
                CompletableFuture.supplyAsync(
                        () -> OrderAnalytics.totalDeliveredRevenue(orders),
                        executor
                );

        CompletableFuture<Map<String, Double>> revenuePerCityFuture =
                CompletableFuture.supplyAsync(
                        () -> OrderAnalytics.revenuePerCity(orders),
                        executor
                );

        CompletableFuture<List<String>> topCategoriesFuture =
                CompletableFuture.supplyAsync(
                        () -> OrderAnalytics.top3CategoriesByRevenue(orders),
                        executor
                );

        CompletableFuture.allOf(
                totalRevenueFuture,
                revenuePerCityFuture,
                topCategoriesFuture
        ).join();

        return new AnalyticsResult(
                totalRevenueFuture.get(),
                revenuePerCityFuture.get(),
                topCategoriesFuture.get()
        );
    }
}
