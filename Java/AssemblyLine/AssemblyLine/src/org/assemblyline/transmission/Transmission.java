package org.assemblyline.transmission;

import org.assemblyline.exceptions.TransmissionTypeNotSupportedException;

public interface Transmission {
    void setTransmission(String input) throws TransmissionTypeNotSupportedException;
    @Override
    String toString();
}
