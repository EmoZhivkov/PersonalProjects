package org.assemblyline.engine;

public class FuelEngine implements Engine {
    private String fuelType;
    private String powerType;
    private String emissionStandart;


    public FuelEngine(String fuelType, String powerType, String emissionStandart) {
        this.fuelType = fuelType;
        this.powerType = powerType;
        this.emissionStandart = emissionStandart;
    }

    @Override
    public String toString() {
        return fuelType + "-" + powerType + "-" + emissionStandart;
    }
}
