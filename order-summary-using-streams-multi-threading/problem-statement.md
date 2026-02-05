## Problem: “Simple Order Summary”

Data: CSV with 100 `Order` records:

```
orderId,customerId,category,amount,city,status
O1,C1,ELECTRONICS,1500,Hyderabad,DELIVERED
O2,C2,BOOKS,200,Bangalore,CANCELLED
...
```

Order class 
```java
public class Order {
    String orderId, customerId, category, city;
    double amount;
    OrderStatus status; // enum: PLACED, CANCELLED, DELIVERED
    // getters + constructor
}
```

***

## Milestone 1:

1. **Total revenue for DELIVERED orders only**

2. **Revenue per city** (Map<String, Double>)

3. **Top 3 categories by revenue** (`Map<String, Double>` sorted descending)


**Deliverable:** `OrderAnalytics.java` with 3 public methods returning these results.

**Scoring:** 30 points (correctness + streams usage).

***

## Milestone 2:

Use `ExecutorService` to compute the 3 analytics **in parallel**.

**Scoring:** 30 points (correct ExecutorService usage).

