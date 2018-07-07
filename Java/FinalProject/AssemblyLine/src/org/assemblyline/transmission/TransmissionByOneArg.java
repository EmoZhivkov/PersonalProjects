package org.assemblyline.transmission;

import org.assemblyline.exceptions.TransmissionTypeNotSupportedException;

import java.util.Set;

public class TransmissionByOneArg implements Transmission {
    String transmission;
    Set<String> allowedTransmissions;

    public TransmissionByOneArg(Set<String> allowedTransmissions) {
        this.allowedTransmissions = allowedTransmissions;
    }

    /**
     * Helper method to set the Transmission of a given vehicle
     * @param input the transmission specs
     */
    @Override
    public void setTransmission(String input) throws TransmissionTypeNotSupportedException{
        if (this.allowedTransmissions.contains(input)) {
            this.transmission = input + "-4";
        } else {
            throw new TransmissionTypeNotSupportedException("The Transmission you have entered is not supported. Enter a new command:");
        }
    }

    @Override
    public String toString() {
        return this.transmission;
    }
}
