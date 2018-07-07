package org.assemblyline.vehicle;

public abstract class Vehicle {
    protected boolean isAssembled;
    protected String vin;

    public boolean checkVin(String vin) {
        return vin.equals(this.vin);
    }

    public void setIsAssembled(boolean b) {
        this.isAssembled = b;
    }

    public boolean getIsAssembled() {
        return isAssembled;
    }

    public String getVin() {
        return this.vin;
    }

    @Override
    abstract public String toString();
}
