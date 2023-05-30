package com.chargepoint;

import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;
import com.chargepoint.service.ScheduleService;
import com.chargepoint.strategy.MaximumChargerUtilisationScheduleStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Main application class.
 */
public class ScheduleApplication {
    public static void main(String[] args) {
        List<Truck> trucks = Arrays.asList(
                new Truck(1, 100, 50),
                new Truck(2, 120, 30),
                new Truck(3, 80, 10),
                new Truck(4, 150, 70)
        );

        List<Charger> chargers = Arrays.asList(
                new Charger(1, 50),
                new Charger(2, 40),
                new Charger(3, 30)
        );

        int timePeriod = 2; // Specified amount of charging time in hours

        ScheduleService scheduleService = new ScheduleService(new MaximumChargerUtilisationScheduleStrategy());

        Map<Charger, List<Truck>> schedule = scheduleService.getSchedule(trucks, chargers, timePeriod);

        scheduleService.printSchedule(schedule);
    }
}
