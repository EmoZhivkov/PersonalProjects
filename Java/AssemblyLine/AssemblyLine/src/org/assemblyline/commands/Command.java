package org.assemblyline.commands;

import org.assemblyline.exceptions.NoManufacturedVehiclesException;
import org.assemblyline.exceptions.VinNotFoundException;

/**
 * Command interface
 * @params multiple Strings in order to meet the needs of the commands
 *
 */
public interface Command {
    String execute(String... input)throws NoManufacturedVehiclesException, VinNotFoundException;
}
