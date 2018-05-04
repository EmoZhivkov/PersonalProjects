package org.interpreter.commands;

import org.interpreter.variables.VariableContainer;

import java.io.*;

public class LoadCommand implements Command, Serializable  {
    private VariableContainer variableContainer;

    public LoadCommand(VariableContainer variableContainer) {
        this.variableContainer = variableContainer;
    }

    public Object execute(String input) {
        try {
            FileInputStream fis = new FileInputStream(input);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.variableContainer.copy((VariableContainer) ois.readObject());

            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Err: File not found");
        } catch (IOException e) {
            System.out.println("Err: Incorrect IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Err: Save Object does not exist");
        }
        return "Ok";
    }

    public VariableContainer getVariableContainer() {
        return this.variableContainer;
    }
}
