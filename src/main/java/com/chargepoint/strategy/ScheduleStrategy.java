package com.chargepoint.strategy;

import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;

import java.util.List;
import java.util.Map;

/**
 * Interface to define the scheduling strategy to be implemented.
 */
public interface ScheduleStrategy {
    public Map<Charger, List<Truck>> getChargingSchedule(List<Truck> trucks, List<Charger> chargers, int timePeriod);
}
