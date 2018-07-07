package org.assemblyline.model;

import org.assemblyline.exceptions.ModelNotSupportedException;

import java.util.Set;

public class ModelByTwoArg implements Model {
    private String model;
    private Set<String> allowedModels;
    private Set<String> allowedModelTypes;

    public ModelByTwoArg(Set<String> allowedModels, Set<String> allowedModelTypes) {
        this.allowedModels = allowedModels;
        this.allowedModelTypes = allowedModelTypes;
    }

    /**
     * Helper method that sets the model of a given car
     * @param input the given model
     */
    @Override
    public void setModel(String input) throws ModelNotSupportedException{
        String[] firstAndSecondArg = input.split("-");

        if (this.allowedModels.contains(firstAndSecondArg[0])
                && this.allowedModelTypes.contains(firstAndSecondArg[1])) {
            this.model = input;
        } else {
            throw new ModelNotSupportedException("The Model you have inputed is not supported. Enter a new command:");

        }
    }

    @Override
    public String toString() {
        String[] temp = this.model.split("-");
        return temp[0] + "-" + temp[1];
    }
}
