package org.assemblyline.model;

import org.assemblyline.exceptions.ModelNotSupportedException;

import java.util.Set;

public class ModelByOneArg  implements Model {
    private String model;
    private Set<String> allowedModels;

    public ModelByOneArg(Set<String> allowedModels) {
        this.allowedModels = allowedModels;
    }

    /**
     * Helper method that sets the model of a given car
     * @param input the given model
     */
    @Override
    public void setModel(String input) throws ModelNotSupportedException {
        if (this.allowedModels.contains(input)) {
            this.model = input + "-sedan";
        } else {
            throw new ModelNotSupportedException("The Model you have inputed is not supported. Enter a new command:");
        }
    }

    @Override
    public String toString() {
        String s = "";
        String[] temp = this.model.split("-");
        if (temp.length == 2) {
            s = temp[0] + "-" + temp[1];
        } else {
            s = temp[0];
        }
        return s;
    }
}
