package org.assemblyline.commands;

import org.assemblyline.exceptions.NoManufacturedVehiclesException;
import org.assemblyline.exceptions.VinNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PrintCommand implements Command {
    private JdbcTemplate db;

    public PrintCommand(JdbcTemplate db) {
        this.db = db;
    }

    /**
     * Prints info about a given vehicle or multiple vehicles their vin
     * @param input the vin
     * @return the information about the vehicle/s
     * @throws NoManufacturedVehiclesException
     * @throws VinNotFoundException
     */
    @Override
    public String execute(String... input) throws NoManufacturedVehiclesException, VinNotFoundException{
        String output = "";

        if (input[0].equals("all")) {
            List<String> vehicleVins = db.queryForList("select vin from Vehicles", String.class);

            if (vehicleVins.isEmpty()) {
                throw new NoManufacturedVehiclesException("There are no manufactored vehicles. Enter a new command:");
            }

            for (String vin :
                    vehicleVins) {
                output = output + this.infoAboutAVin(vin) + System.lineSeparator();
            }
        } else {
            try {
                output = this.infoAboutAVin(input[0]);
            } catch (VinNotFoundException e) {
                throw e;
            }
        }
        return output;
    }

    /**
     * Prints info about a vehicle through a given vin
     * @param vin
     * @return the information about the vehicle
     * @throws VinNotFoundException
     */
    private String infoAboutAVin(String vin) throws VinNotFoundException{
        String model = "";
        String engine = "";
        String transmission = "";
        String state = "";

        int modelId = 0;
        int engineId = 0;
        int transmissionId = 0;
        int vehicleStateId = 0;
        try {
            modelId = db.queryForObject("select modelId from Vehicles where vin = '" + vin + "'", Integer.class);
            engineId = db.queryForObject("select engineId from Vehicles where vin = '" + vin + "'", Integer.class);
            transmissionId = db.queryForObject("select transmissionId from Vehicles where vin = '" + vin + "'", Integer.class);
            vehicleStateId = db.queryForObject("select vehicleStateId from Vehicles where vin = '" + vin + "'", Integer.class);
        } catch (EmptyResultDataAccessException e) {
            throw new VinNotFoundException("A vehicle with the selected vin does not exist. Enter a new command:");
        }

        if (db.queryForObject("select definedWith from Vehicles where vin = '" + vin +"'", String.class).equals("l")) {
            model = db.queryForObject("select modelName from Models where id = " + modelId, String.class);
            if (db.queryForObject("select modelType from Models where id = " + modelId, String.class) != null) {
                model = model + " " + db.queryForObject("select modelType from Models where id = " + modelId, String.class);
            }

            transmission = db.queryForObject("select transType from Transmissions where id = " + transmissionId, String.class) + "-" +
                    db.queryForObject("select numOfGears from Transmissions where id = " + transmissionId, Integer.class);

            if (db.queryForObject("select turbo from Engines where id = " + engineId, Integer.class) == 1) {
                engine = db.queryForObject("select fuelType from Engines where id = " + engineId, String.class) + "-" +
                        db.queryForObject("select litres from Engines where id = " + engineId, Integer.class) + "LT-" +
                        db.queryForObject("select emissionStandart from Engines where id = " + engineId, String.class);
            } else {
                engine = db.queryForObject("select fuelType from Engines where id = " + engineId, String.class) + "-" +
                        db.queryForObject("select litres from Engines where id = " + engineId, Integer.class) + "L-" +
                        db.queryForObject("select emissionStandart from Engines where id = " + engineId, String.class);
            }
        } else {
            model = db.queryForObject("select modelName from Models where id = " + modelId, String.class);
            if (db.queryForObject("select modelType from Models where id = " + modelId, String.class) != null) {
                model = model + " " + db.queryForObject("select modelType from Models where id = " + modelId, String.class);
            }

            transmission = db.queryForObject("select transType from Transmissions where id = " + transmissionId, String.class) + "-" +
                    db.queryForObject("select numOfGears from Transmissions where id = " + transmissionId, Integer.class);

            if (db.queryForObject("select turbo from Engines where id = " + engineId, Integer.class) == 1) {
                engine = db.queryForObject("select fuelType from Engines where id = " + engineId, String.class) + "-" +
                        db.queryForObject("select hp from Engines where id = " + engineId, Integer.class) + "hpT-" +
                        db.queryForObject("select emissionStandart from Engines where id = " + engineId, String.class);
            } else {
                engine = db.queryForObject("select fuelType from Engines where id = " + engineId, String.class) + "-" +
                        db.queryForObject("select hp from Engines where id = " + engineId, Integer.class) + "hp-" +
                        db.queryForObject("select emissionStandart from Engines where id = " + engineId, String.class);
            }
        }

        if (db.queryForObject("select state from VehicleStates where id = " + vehicleStateId, Integer.class) == 1) {
            state = "assembled";
        } else {
            state = "disassembled";
        }

        return vin + " " + model + " " + engine + " " + transmission + " " + state;
    }
}
