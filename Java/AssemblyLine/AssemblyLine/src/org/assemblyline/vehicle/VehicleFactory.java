package org.assemblyline.vehicle;

import org.assemblyline.exceptions.EngineNotSupportedException;
import org.assemblyline.exceptions.ModelNotSupportedException;
import org.assemblyline.exceptions.TransmissionTypeNotSupportedException;

public interface VehicleFactory {
    Vehicle createVehicle(String vehicleSpecs, String vin) throws EngineNotSupportedException, ModelNotSupportedException, TransmissionTypeNotSupportedException;
}
