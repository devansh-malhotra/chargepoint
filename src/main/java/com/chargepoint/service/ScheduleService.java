package com.chargepoint.service;

import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;
import com.chargepoint.strategy.ScheduleStrategy;
import com.chargepoint.util.ScheduleUtility;

import java.util.List;
import java.util.Map;

/**
 * Service to handle charging schedules.
 */
public class ScheduleService {
    private ScheduleStrategy strategy;

    public ScheduleService(ScheduleStrategy strategy){
        this.strategy = strategy;
    }

    public Map<Charger, List<Truck>> getSchedule(List<Truck> trucks, List<Charger> chargers, int timePeriod){
        return strategy.getChargingSchedule(trucks, chargers, timePeriod);
    }

    public void printSchedule(Map<Charger, List<Truck>> schedule) {
        ScheduleUtility.printSchedule(schedule);
    }
}
