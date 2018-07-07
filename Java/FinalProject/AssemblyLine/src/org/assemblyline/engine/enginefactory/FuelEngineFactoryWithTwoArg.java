package org.assemblyline.engine.enginefactory;

import org.assemblyline.engine.Engine;
import org.assemblyline.engine.EngineFactory;
import org.assemblyline.engine.FuelEngine;
import org.assemblyline.exceptions.EngineNotSupportedException;

import java.util.Set;

public class FuelEngineFactoryWithTwoArg implements EngineFactory {
    private Set<String> fuelTypes;
    private Set<String> powerTypes;
    private Set<String> hpThatTranslatesInTurbo;
    private Set<String> emissionStandarts;

    public FuelEngineFactoryWithTwoArg(Set<String> fuelTypes, Set<String> powerTypes,
                                       Set<String> hpThatTranslatesInTurbo, Set<String> emissionStandarts) {
        this.fuelTypes = fuelTypes;
        this.powerTypes = powerTypes;
        this.hpThatTranslatesInTurbo = hpThatTranslatesInTurbo;
        this.emissionStandarts = emissionStandarts;
    }

    /**
     * Creates an engine by the given specs
     * @param input the specs
     * @return an Engine
     */
    @Override
    public Engine createEngine(String input) throws EngineNotSupportedException{
        String fuelType = "";
        String powerType = "";
        String[] temp = input.split("-");

        if (fuelTypes.contains(temp[0])) {
            fuelType = temp[0];
        } else {
            throw new EngineNotSupportedException("The Engine you have inputed is not supported. Enter a new command");
        }

        if (powerTypes.contains(temp[1])) {
            powerType = temp[1];
        } else if (hpThatTranslatesInTurbo.contains(temp[1])) {
            powerType = temp[1] + "T";
        } else {
            throw new EngineNotSupportedException("The Engine you have inputed is not supported. Enter a new command");
        }
        return new FuelEngine(fuelType, powerType, "euro3");
    }
}
