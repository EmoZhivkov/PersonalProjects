package org.assemblyline;

import org.assemblyline.commands.Command;
import org.assemblyline.engine.EngineFactory;
import org.assemblyline.engine.enginefactory.FuelEngineFactoryWithOneArg;
import org.assemblyline.engine.enginefactory.FuelEngineFactoryWithThreeArg;
import org.assemblyline.engine.enginefactory.FuelEngineFactoryWithTwoArg;
import org.assemblyline.exceptions.ModelNotSupportedException;
import org.assemblyline.model.Model;
import org.assemblyline.model.ModelByOneArg;
import org.assemblyline.model.ModelByTwoArg;
import org.assemblyline.model.SuvModel;
import org.assemblyline.transmission.Transmission;
import org.assemblyline.transmission.TransmissionByOneArg;
import org.assemblyline.transmission.TransmissionByTwoArg;
import org.assemblyline.vehicle.VehicleFactory;
import org.assemblyline.vehicle.vehiclefactory.CarFactoryWithThreeArg;
import org.assemblyline.vehicle.vehiclefactory.CarFactoryWithTwoArg;
import org.assemblyline.vehicle.vehiclefactory.SuvFactoryWithThreeArg;
import org.assemblyline.vehicle.vehiclefactory.SuvFactoryWithTwoArg;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DbConfig.class)
public class ParametersTest {
    @Autowired
    JdbcTemplate db;

    Set<String> allowedTransmissions = new HashSet<>();

    Set<String> allowedCarModels = new HashSet<>();

    Set<String> allowedSuvModels = new HashSet<>();

    Set<String> allowedModelTypes = new HashSet<>();

    Set<String> fuelTypes = new HashSet<>();

    Set<String> powerTypes = new HashSet<>();

    Set<String> hpThatTranslatesInTurbo = new HashSet<>();

    Set<String> emissionStandarts = new HashSet<>();

    Map<Integer, Model> modelCarSetter = new HashMap<>();

    Map<Integer, Model> modelSuvSetter = new HashMap<>();

    Map<Integer, Transmission> transmissionSetter = new HashMap<>();

    Map<Integer, EngineFactory> engineSetter = new HashMap<>();

    Map<Pair<String, Integer>, VehicleFactory> vehicleFactories = new HashMap<>();

    Map<String, Command> commands = new HashMap<>();

    @Before
    public void setUpSetsAndMaps() {
        allowedTransmissions.add("Auto");
        allowedTransmissions.add("Manual");
        allowedTransmissions.add("Auto-4");
        allowedTransmissions.add("Auto-5");
        allowedTransmissions.add("Auto-6");
        allowedTransmissions.add("Auto-8");
        allowedTransmissions.add("Manual-4");
        allowedTransmissions.add("Manual-5");
        allowedTransmissions.add("Manual-6");

        allowedCarModels.add("A1");
        allowedCarModels.add("A2");
        allowedCarModels.add("A3");
        allowedCarModels.add("A4");
        allowedCarModels.add("A5");
        allowedCarModels.add("A6");
        allowedCarModels.add("A7");
        allowedCarModels.add("A8");

        allowedSuvModels.add("Q1");
        allowedSuvModels.add("Q2");
        allowedSuvModels.add("Q3");
        allowedSuvModels.add("Q4");
        allowedSuvModels.add("Q5");
        allowedSuvModels.add("Q6");
        allowedSuvModels.add("Q7");
        allowedSuvModels.add("Q8");

        allowedModelTypes.add("hatchback");
        allowedModelTypes.add("sedan");
        allowedModelTypes.add("kombi");

        fuelTypes.add("B");
        fuelTypes.add("D");

        powerTypes.add("1L");
        powerTypes.add("1LT");
        powerTypes.add("2L");
        powerTypes.add("2LT");
        powerTypes.add("3L");
        powerTypes.add("3LT");
        powerTypes.add("4L");
        powerTypes.add("4LT");
        powerTypes.add("5L");
        powerTypes.add("5LT");
        powerTypes.add("6L");
        powerTypes.add("6LT");
        powerTypes.add("8L");
        powerTypes.add("8LT");
        powerTypes.add("73hp");
        powerTypes.add("74hp");
        powerTypes.add("72hp");
        powerTypes.add("95hpT");
        powerTypes.add("96hpT");
        powerTypes.add("94hpT");
        powerTypes.add("197hp");
        powerTypes.add("198hp");
        powerTypes.add("196hp");
        powerTypes.add("256hpT");
        powerTypes.add("257hpT");
        powerTypes.add("255hpT");
        powerTypes.add("328hp");
        powerTypes.add("329hp");
        powerTypes.add("327hp");
        powerTypes.add("427hpT");
        powerTypes.add("428hpT");
        powerTypes.add("426hpT");
        powerTypes.add("339hp");
        powerTypes.add("340hp");
        powerTypes.add("338hp");
        powerTypes.add("439hpT");
        powerTypes.add("440hpT");
        powerTypes.add("438hpT");
        powerTypes.add("443hp");
        powerTypes.add("444hp");
        powerTypes.add("442hp");
        powerTypes.add("577hpT");
        powerTypes.add("578hpT");
        powerTypes.add("576hpT");
        powerTypes.add("683hp");
        powerTypes.add("684hp");
        powerTypes.add("682hp");
        powerTypes.add("888hpT");
        powerTypes.add("889hpT");
        powerTypes.add("887hpT");
        powerTypes.add("986hp");
        powerTypes.add("987hp");
        powerTypes.add("985hp");
        powerTypes.add("1285hpT");
        powerTypes.add("1286hpT");
        powerTypes.add("1284hpT");

        hpThatTranslatesInTurbo.add("95hp");
        hpThatTranslatesInTurbo.add("96hp");
        hpThatTranslatesInTurbo.add("94hp");
        hpThatTranslatesInTurbo.add("256hp");
        hpThatTranslatesInTurbo.add("257hp");
        hpThatTranslatesInTurbo.add("255hp");
        hpThatTranslatesInTurbo.add("427hp");
        hpThatTranslatesInTurbo.add("428hp");
        hpThatTranslatesInTurbo.add("426hp");
        hpThatTranslatesInTurbo.add("439hp");
        hpThatTranslatesInTurbo.add("440hp");
        hpThatTranslatesInTurbo.add("438hp");
        hpThatTranslatesInTurbo.add("577hp");
        hpThatTranslatesInTurbo.add("578hp");
        hpThatTranslatesInTurbo.add("576hp");
        hpThatTranslatesInTurbo.add("888hp");
        hpThatTranslatesInTurbo.add("889hp");
        hpThatTranslatesInTurbo.add("887hp");
        hpThatTranslatesInTurbo.add("1285hp");
        hpThatTranslatesInTurbo.add("1286hp");
        hpThatTranslatesInTurbo.add("1284hp");

        emissionStandarts.add("euro3");
        emissionStandarts.add("euro4");
        emissionStandarts.add("euro5");
        emissionStandarts.add("euro6");

        modelCarSetter.put(1, new ModelByOneArg(allowedCarModels));
        modelCarSetter.put(2, new ModelByTwoArg(allowedCarModels, allowedModelTypes));

        modelSuvSetter.put(1, new SuvModel(allowedSuvModels));

        transmissionSetter.put(1, new TransmissionByOneArg(allowedTransmissions));
        transmissionSetter.put(2, new TransmissionByTwoArg(allowedTransmissions));

        engineSetter.put(1, new FuelEngineFactoryWithOneArg(fuelTypes, powerTypes, hpThatTranslatesInTurbo, emissionStandarts));
        engineSetter.put(2, new FuelEngineFactoryWithTwoArg(fuelTypes, powerTypes, hpThatTranslatesInTurbo, emissionStandarts));
        engineSetter.put(3, new FuelEngineFactoryWithThreeArg(fuelTypes, powerTypes, hpThatTranslatesInTurbo, emissionStandarts));

        vehicleFactories.put(new Pair<>("car", 2), new CarFactoryWithTwoArg(modelCarSetter, transmissionSetter, engineSetter));
        vehicleFactories.put(new Pair<>("car", 3), new CarFactoryWithThreeArg(modelCarSetter, transmissionSetter, engineSetter));
        vehicleFactories.put(new Pair<>("suv", 2), new SuvFactoryWithTwoArg(modelSuvSetter, transmissionSetter, engineSetter));
        vehicleFactories.put(new Pair<>("suv", 3), new SuvFactoryWithThreeArg(modelSuvSetter, transmissionSetter, engineSetter));
    }

    @Test
    public void modelsTest() {
        Model model = new ModelByOneArg(allowedCarModels);
        String exp = "";
        try {
            model.setModel("A10");
        } catch (ModelNotSupportedException e) {
            exp = "fail";
        }
        Assert.assertEquals("fail", exp);
    }
}
