package org.assemblyline.vehicle.vehiclefactory;

import org.assemblyline.engine.Engine;
import org.assemblyline.engine.EngineFactory;
import org.assemblyline.exceptions.EngineNotSupportedException;
import org.assemblyline.exceptions.ModelNotSupportedException;
import org.assemblyline.exceptions.TransmissionTypeNotSupportedException;
import org.assemblyline.model.Model;
import org.assemblyline.transmission.Transmission;
import org.assemblyline.vehicle.Car;
import org.assemblyline.vehicle.VehicleFactory;

import java.util.Map;

public class CarFactoryWithThreeArg implements VehicleFactory {
    private Map<Integer, Model> modelCarSetter;
    private Map<Integer, Transmission> transmissionSetter;
    private Map<Integer, EngineFactory> engineSetter;

    private Model model;
    private Engine engine;
    private EngineFactory engineFactory;
    private Transmission transmission;

    public CarFactoryWithThreeArg(Map<Integer, Model> modelCarSetter, Map<Integer, Transmission> transmissionSetter,
                                Map<Integer, EngineFactory> engineSetter) {
        this.modelCarSetter = modelCarSetter;
        this.transmissionSetter = transmissionSetter;
        this.engineSetter = engineSetter;
    }

    /**
     *
     * Creates a car by the given specifications
     * @param input specs of the car
     * @param vin
     * @return a Car
     * @throws EngineNotSupportedException
     * @throws ModelNotSupportedException
     * @throws TransmissionTypeNotSupportedException
     */
    @Override
    public Car createVehicle(String input, String vin) throws EngineNotSupportedException, ModelNotSupportedException, TransmissionTypeNotSupportedException {
        String[] temp = input.split(" ");
        String engineSpecs = "";
        String modelSpecs = "";
        String transmissionSpecs = "";
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].contains("engine")) {
                String[] s = temp[i].split("=");
                engineSpecs = s[1];
            } else if (temp[i].contains("model")) {
                String[] s = temp[i].split("=");
                modelSpecs = s[1];
            } else if (temp[i].contains("transmission")) {
                String[] s = temp[i].split("=");
                transmissionSpecs = s[1];
            }
        }

        if (engineSpecs.equals("")) {
            throw new EngineNotSupportedException("The Engine you have entered is not supported. Enter a new command:");
        } else if (modelSpecs.equals("")) {
            throw new ModelNotSupportedException("The Model you have entered is not supported. Enter a new command:");
        } else if (transmissionSpecs.equals("")) {
            throw new TransmissionTypeNotSupportedException("The Transmission you have entered is not supported. Enter a new command:");
        }

        try {
            this.transmission = this.transmissionSetter.get(transmissionSpecs.split("-").length);
            this.transmission.setTransmission(transmissionSpecs);

            this.model = this.modelCarSetter.get(modelSpecs.split("-").length);
            this.model.setModel(modelSpecs);

            this.engineFactory = this.engineSetter.get(engineSpecs.split("-").length);
            this.engine = this.engineFactory.createEngine(engineSpecs);
        } catch (TransmissionTypeNotSupportedException e) {
            System.out.println(e.getMessage());
        } catch (ModelNotSupportedException e) {
            System.out.println(e.getMessage());
        } catch (EngineNotSupportedException e) {
            System.out.println(e.getMessage());
        }


        return new Car(vin, this.model, this.engine, this.transmission);
    }
}
