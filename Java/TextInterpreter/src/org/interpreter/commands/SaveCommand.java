package org.interpreter.commands;

import org.interpreter.Interpreter;
import org.interpreter.variables.VariableContainer;

import java.io.*;

public class SaveCommand extends Interpreter implements Command, Serializable  {
    private VariableContainer variableContainer;

    public SaveCommand(VariableContainer variableContainer) {
        this.variableContainer = variableContainer;
    }

    public Object execute(String input) {
        File file = new File(input);

        try {
            FileOutputStream fos = new FileOutputStream(input, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.variableContainer);

            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Err: File not found");
        } catch (IOException e) {
            System.out.println("Err: Incorrect IO");
            e.printStackTrace();
        }
        return "Ok";
    }
}
