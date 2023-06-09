package com.chargepoint.model;

/**
 * Class defining the Charger entity.
 */
public class Charger {
    private int id;
    private int chargingRate;

    public Charger(int id, int chargingRate) {
        this.id = id;
        this.chargingRate = chargingRate;
    }

    public int getId() {
        return id;
    }

    public int getChargingRate() {
        return chargingRate;
    }
}
