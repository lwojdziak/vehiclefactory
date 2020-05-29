package com.ludwikwojdziak;

import com.ludwikwojdziak.VehicleFactory.Order;
import com.ludwikwojdziak.VehicleFactory.OrdersParser;
import com.ludwikwojdziak.VehicleFactory.VehicleFactory;
import com.ludwikwojdziak.VehicleFactory.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        OrdersParser ordersParser = new OrdersParser();
        VehicleFactory vehicleFactory = new VehicleFactory();

        try {
            orders = ordersParser.parseOrder();
        } catch (Exception e) {
            orders.clear();
        }

        if(orders.size() > 0) {
            vehicleFactory.produce(orders);
        }

    }
}
