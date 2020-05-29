package com.ludwikwojdziak.VehicleFactory;

import java.util.ArrayList;
import java.util.List;

public class VehicleFactory {

    public void produce(List<Order> orders) {
        List<VehicleProductionThread> threads = new ArrayList<>();

        for (Order order: orders) {
            VehicleType type = order.type;
            VehicleProductionThread vehicleProductionThread = new VehicleProductionThread.Builder()
                    .vehicleType(type)
                    .productionTime(getProductionTime(type))
                    .productionCost(getProductionCost(type))
                    .build();
            threads.add(vehicleProductionThread);
            vehicleProductionThread.thread.start();
        }
    }

    private int getProductionTime(VehicleType vehicleType){
        int productionTime;
        switch (vehicleType) {
            case CAR:
                productionTime = 10;
                break;
            case MOTORCYCLE:
                productionTime = 5;
                break;
            case TRUCK:
                productionTime = 15;
                break;
            default:
                productionTime = 0;
        }
        return productionTime;
    }

    private int getProductionCost(VehicleType vehicleType){
        int productionCost;
        switch (vehicleType) {
            case CAR:
                productionCost = 1000;
                break;
            case MOTORCYCLE:
                productionCost = 600;
                break;
            case TRUCK:
                productionCost = 2000;
                break;
            default:
                productionCost = 0;
        }
        return productionCost;
    }
}
