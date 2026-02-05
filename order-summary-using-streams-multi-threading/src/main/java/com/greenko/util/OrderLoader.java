package com.greenko.util;

import com.greenko.model.Order;
import com.greenko.model.OrderStatus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class OrderLoader {

    public static List<Order> loadOrders(String csvFilePath) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("orders.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    Order order = new Order(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            Double.parseDouble(data[3].trim()),
                            data[4].trim(),
                            OrderStatus.valueOf(data[5].trim())
                    );
                    orders.add(order);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }

        System.out.println("Loaded " + orders.size() + " orders");
        return orders;
    }


}

