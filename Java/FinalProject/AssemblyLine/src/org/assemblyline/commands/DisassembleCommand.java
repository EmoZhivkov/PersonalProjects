package org.assemblyline.commands;

import org.assemblyline.exceptions.VinNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DisassembleCommand implements Command {
    private JdbcTemplate db;

    public DisassembleCommand(JdbcTemplate db) {
        this.db = db;
    }

    /**
     * Disassembles a given vehicle by it's vin
     * @param input vin of a given vehicle
     * @return a String confirmation that the operation completed successfully
     * @throws VinNotFoundException
     */
    @Override
    public String execute(String... input) throws VinNotFoundException {
        int cnt = 0;
        List<String> vins = db.queryForList("select vin from Vehicles", String.class);
        for (String vin :
                vins) {
            int isAssembled = db.queryForObject("select state from VehicleStates where id = (select vehicleStateId from Vehicles where" +
                    " vin = '"+ input[0] + "')", Integer.class);

            if (isAssembled == 1) {
                db.execute("update Vehicles set vehicleStateId = 1 where vin = '" + input[0] + "'");
                cnt++;
            }
        }
        if (cnt == 0) {
            throw new VinNotFoundException("A vehicle with the selected vin does not exist. Enter a new command:");
        }
        return "The vehicle with a vin " + input[0] + " was successfully disassembled";
    }
}
