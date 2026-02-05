package Analytics;

import com.greenko.model.Order;
import com.greenko.util.OrderLoader;
import java.util.List;

public class app {
	public static void main(String[] args) throws Exception {
        List<Order> orders = OrderLoader.loadOrders("orders.csv");
        OrderAnalyticsParallel.runAnalyticsInParallel(orders);
    }
}




    