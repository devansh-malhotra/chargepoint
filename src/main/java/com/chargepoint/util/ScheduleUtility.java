package com.chargepoint.util;

import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Utility class for charging schedule application.
 */
public class ScheduleUtility {
    public static void printSchedule(Map<Charger, List<Truck>> chargingSchedule) {
        for (Map.Entry<Charger, List<Truck>> entry : chargingSchedule.entrySet()) {
            System.out.print(entry.getKey().getId() + ": ");
            List<Integer> truckIds = new ArrayList<>();
            for (Truck truck : entry.getValue()) {
                truckIds.add(truck.getId());
            }
            System.out.println(String.join(", ", truckIds.toString()));
        }
    }
}
