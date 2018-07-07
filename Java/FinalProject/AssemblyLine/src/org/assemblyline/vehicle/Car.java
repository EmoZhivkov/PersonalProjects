package org.assemblyline.vehicle;

import org.assemblyline.engine.Engine;
import org.assemblyline.model.Model;
import org.assemblyline.transmission.Transmission;

public class Car extends Vehicle {
    private Model model;
    private Engine engine;
    private Transmission transmission;

    public Car(String vin, Model model, Engine engine, Transmission transmission) {
        this.vin = vin;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.isAssembled = true;
    }

    @Override
    public String toString() {
        return this.vin + " " + this.model + " " + this.engine + " " + this.transmission;
    }
}
