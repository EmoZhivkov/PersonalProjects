package org.assemblyline.commands;

import org.assemblyline.Pair;
import org.assemblyline.exceptions.EngineNotSupportedException;
import org.assemblyline.exceptions.ModelNotSupportedException;
import org.assemblyline.exceptions.TransmissionTypeNotSupportedException;
import org.assemblyline.transmission.Transmission;
import org.assemblyline.vehicle.Vehicle;
import org.assemblyline.vehicle.VehicleFactory;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.Map;
import java.util.Random;

public class CreateCommand implements Command {
    private static long seed = 3345;
    private JdbcTemplate db;
    private Map<Pair<String, Integer>, VehicleFactory> vehicleFactories;
    private String vinInfix;

    public CreateCommand(JdbcTemplate db, Map<Pair<String, Integer>, VehicleFactory> vehicleFactories) {
        this.db = db;
        this.vehicleFactories = vehicleFactories;
    }

    /**
     * Creates a vehicle
     * @param engineSpecsAndVinInfix
     * @return a String confirmation if the method executed successfully
     */

    @Override
    public String execute(String... engineSpecsAndVinInfix) {
        this.vinInfix = engineSpecsAndVinInfix[1];

        String[] temp = engineSpecsAndVinInfix[0].split(" ");

        String typeOfVehicle = temp[0];
        int numOfArgs = temp.length - 1;
        Pair<String, Integer> pair = new Pair<>(typeOfVehicle, numOfArgs);

        String vehicleSpecs = "";
        for (int i = 1; i < temp.length; i++) {
            if (i == temp.length - 1) {
                vehicleSpecs = vehicleSpecs + temp[i];
                break;
            }
            vehicleSpecs = vehicleSpecs + temp[i] + " ";
        }

        VehicleFactory vehicleFactory = this.vehicleFactories.get(pair);
        Vehicle vehicle;
        try {
            vehicle = vehicleFactory.createVehicle(vehicleSpecs, this.generateVIN());
        } catch (EngineNotSupportedException e) {
            return e.getMessage();
        } catch (ModelNotSupportedException e) {
            return e.getMessage();
        } catch (TransmissionTypeNotSupportedException e) {
            return e.getMessage();
        }


        String temp1 = vehicle.toString();

        String[] specs = temp1.split(" ");

        String vin = specs[0];

        String[] model = specs[1].split("-");
        int modelId = 0;
        if (model.length == 2) {
            modelId = db.queryForObject(("select id from Models where modelName = " + "'" + model[0] + "' and modelType = " + "'" + model[1] + "'"), Integer.class);
        } else {
            modelId = db.queryForObject(("select id from Models where modelName = " + "'" + model[0] + "'"), Integer.class);
        }

        String definedWith = "";

        String[] engine = specs[2].split("-");
        int engineId = 0;
        if (engine[1].contains("T")) {
            if (engine[1].contains("L")) {
                definedWith = "l";
                int litres = Integer.parseInt(String.valueOf(engine[1].charAt(0)));

                engineId = db.queryForObject("select id from Engines where " +
                        "fuelType = " + "'" + engine[0] + "' and litres = " + litres + " and turbo = " + 1 + " and emissionStandart = " + "'" + engine[2] + "'", Integer.class);

            } else if (engine[1].contains("hp")) {
                definedWith = "hp";
                String[] hpInString = engine[1].split("h");
                int hp = Integer.parseInt(hpInString[0]);

                engineId = db.queryForObject("select id from Engines where " +
                        "fuelType = " + "'" + engine[0] + "' and hp = " + hp + " and turbo = " + 1 + " and emissionStandart = " + "'" + engine[2] + "'", Integer.class);
            }
        } else {
            if (engine[1].contains("L")) {
                definedWith = "l";
                int litres = Integer.parseInt(String.valueOf(engine[1].charAt(0)));

                engineId = db.queryForObject("select id from Engines where " +
                        "fuelType = " + "'" + engine[0] + "' and litres = " + litres + " and turbo = " + 0 + " and emissionStandart = " + "'" + engine[2] + "'", Integer.class);

            } else if (engine[1].contains("hp")) {
                definedWith = "hp";
                String[] hpInString = engine[1].split("h");
                int hp = Integer.parseInt(hpInString[0]);

                engineId = db.queryForObject("select id from Engines where " +
                        "fuelType = " + "'" + engine[0] + "' and hp = " + hp + " and turbo = " + 0 + " and emissionStandart = " + "'" + engine[2] + "'", Integer.class);
            }
        }

        String[] transmission = specs[3].split("-");
        int transmissionId = db.queryForObject("select id from Transmissions where " +
                "transType = " + "'" + transmission[0] + "' and numOfGears = " + transmission[1], Integer.class);

        db.execute("insert into Vehicles (vin, vehicleType, modelId, engineId, transmissionId, vehicleStateId, definedWith) values " +
                "('" + vin + "', " + "'"+ typeOfVehicle +"', " + modelId + ", " + engineId + ", " + transmissionId + ", 2, "+"'" + definedWith+"'" +")");

        return "A vehicle with the given parameters was successfully created";
    }

    /**
     * @return a random VIN with the given restrictions
     */

    private String generateVIN() {
        String allowedSymbols = "ABCDEFGHJKLMNPRSTUVWXYZ" +
                "0123456789";

        String vin = new String();
        vin = vin + this.vinInfix;
        Random random = new Random(this.seed);
        this.seed++;
        for (int i = 0; i < 14; i++) {
            vin = vin + allowedSymbols.charAt(random.nextInt(allowedSymbols.length() - 1));
        }

        return vin;
    }
}
