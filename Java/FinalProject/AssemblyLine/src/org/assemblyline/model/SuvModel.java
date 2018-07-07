package org.assemblyline.model;

import org.assemblyline.exceptions.ModelNotSupportedException;

import java.util.Set;

public class SuvModel implements Model {
    private String model;
    private Set<String> allowedModels;

    public SuvModel(Set<String> allowedModels) {
        this.allowedModels = allowedModels;
    }

    /**
     * Helper method that sets the model of a given suv
     * @param input the given model
     */
    @Override
    public void setModel(String input) throws ModelNotSupportedException{
        if (this.allowedModels.contains(input)) {
            this.model = input;
        } else {
            throw new ModelNotSupportedException("The Model you have inputed is not supported. Enter a new command:");

        }
    }

    @Override
    public String toString() {
        return this.model;
    }
}
