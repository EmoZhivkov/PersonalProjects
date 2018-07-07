package org.assemblyline.engine.enginefactory;

import org.assemblyline.engine.Engine;
import org.assemblyline.engine.EngineFactory;
import org.assemblyline.engine.FuelEngine;
import org.assemblyline.exceptions.EngineNotSupportedException;

import java.util.Set;

public class FuelEngineFactoryWithOneArg implements EngineFactory {
    private Set<String> fuelTypes;
    private Set<String> powerTypes;
    private Set<String> hpThatTranslatesInTurbo;
    private Set<String> emissionStandarts;

    public FuelEngineFactoryWithOneArg(Set<String> fuelTypes, Set<String> powerTypes,
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
    public Engine createEngine(String input) throws EngineNotSupportedException {
        if (fuelTypes.contains(input)) {
            return new FuelEngine(input, "73hp", "euro3");
        } else {
            throw new EngineNotSupportedException("The Engine you have inputed is not supported. Enter a new command");
        }
    }
}
