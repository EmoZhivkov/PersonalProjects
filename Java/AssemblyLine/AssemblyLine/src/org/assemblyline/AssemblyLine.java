package org.assemblyline;

import org.assemblyline.commands.Command;
import org.assemblyline.exceptions.NoManufacturedVehiclesException;
import org.assemblyline.exceptions.VinNotFoundException;
import org.assemblyline.vehicle.Vehicle;

import java.util.List;
import java.util.Map;

/**
 * Sums up the whole program, implementing and executing the whole flow
 */
public class AssemblyLine {
    private Map<String, Command> commands;
    private String location;
    private int numOfFactory;

    public AssemblyLine(String location, int numOfFactory, Map<String, Command> commands) {
        this.commands = commands;
        this.location = location;
        this.numOfFactory = numOfFactory;
    }


    /**
     * Summing the process up to the last bit
     * @param input the desired command
     * @return the selected command's output
     */
    public String execute(String input) {
        String vinInfix = this.location + this.numOfFactory;

        String[] temp = input.split(" ");
        Command command = this.commands.get(temp[0]);

        String arg = "";
        for (int i = 1; i < temp.length; i++) {
            if (i == temp.length - 1) {
                arg = arg + temp[i];
                break;
            }
            arg = arg + temp[i] + " ";
        }
        try {
            return command.execute(arg, vinInfix);
        } catch (VinNotFoundException e) {
            return e.getMessage();
        } catch (NoManufacturedVehiclesException e) {
            return e.getMessage();
        } catch (NullPointerException e) {
            return "The command you have entered is not supported. Enter a new command:";
        }
    }
}
