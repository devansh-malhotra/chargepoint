package com.chargepoint;


import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;
import com.chargepoint.service.ScheduleService;
import com.chargepoint.strategy.MaximumChargerUtilisationScheduleStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class TruckChargingScheduleTest {
    @Test
    void testGetChargingSchedule() {
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

        int timePeriod = 3;

        ScheduleService scheduleService = new ScheduleService(new MaximumChargerUtilisationScheduleStrategy());

        Map<Charger, List<Truck>> chargingSchedule = scheduleService.getSchedule(trucks, chargers, timePeriod);

        // Assertions for charger 1
        Assertions.assertEquals(2, chargingSchedule.get(chargers.get(0)).size());
        Assertions.assertTrue(chargingSchedule.get(chargers.get(0)).containsAll(Arrays.asList(trucks.get(0), trucks.get(1))));
        Assertions.assertTrue(chargingSchedule.get(chargers.get(0)).contains(trucks.get(1)));

        // Assertions for charger 2
        Assertions.assertEquals(1, chargingSchedule.get(chargers.get(1)).size());
        Assertions.assertTrue(chargingSchedule.get(chargers.get(1)).contains(trucks.get(3)));

        // Assertions for charger 3
        Assertions.assertEquals(1, chargingSchedule.get(chargers.get(2)).size());
        Assertions.assertTrue(chargingSchedule.get(chargers.get(2)).contains(trucks.get(2)));
    }
}