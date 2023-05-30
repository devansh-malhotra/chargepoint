package com.chargepoint.strategy;

import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;

import java.util.*;

/**
 * This charging strategy chooses the charger with maximum charge rate to charge trucks that have the most amount of charging to be done.
 * This approach maximises utilization for every charger before moving on to the next charger.
 */
public class MaximumChargerUtilisationScheduleStrategy implements ScheduleStrategy {
    @Override
    public Map<Charger, List<Truck>> getChargingSchedule(List<Truck> trucks, List<Charger> chargers, int timePeriod) {
        Map<Charger, List<Truck>> schedule = new HashMap<>();

        // Sort trucks by their remaining charge time in descending order
        trucks.sort(Comparator.comparingInt(Truck::getRemainingCharge).reversed());

        // Sort chargers by their charging rate in descending order
        chargers.sort(Comparator.comparingInt(Charger::getChargingRate).reversed());

        for (Charger charger : chargers) {
            float remainingTime = timePeriod;
            List<Truck> assignedTrucks = new ArrayList<>();
            if(remainingTime > 0) {
                for (Truck truck : trucks) {
                    int remainingCharge = truck.getRemainingCharge();
                    float chargingTime = (float) remainingCharge / charger.getChargingRate();
                    if (remainingCharge > 0 && chargingTime > 0 && remainingTime >= chargingTime) {
                        assignedTrucks.add(truck);
                        // Update the current charge level of the truck to its maximum capacity
                        truck.setCurrentCharge(truck.getBatteryCapacity());
                        // Update the time for which the current charger can charge
                        remainingTime -= chargingTime;
                    }
                }
            }
            schedule.put(charger, assignedTrucks);
        }
        return schedule;
    }

}
