package org.interpreter.commands;

import org.interpreter.Interpreter;
import org.interpreter.exceptions.VariableNotFoundException;
import org.interpreter.variables.Type;
import org.interpreter.variables.VariableContainer;

import java.io.Serializable;
import java.util.Map;

public class SetCommand extends Interpreter implements Command, Serializable {
    VariableContainer var;
    Map<String, Type> variableTypesSupported;

    public SetCommand(VariableContainer var, Map<String, Type> variableTypesSupported) {
        this.var = var;
        this.variableTypesSupported = variableTypesSupported;
    }

    private Type findType(String input) throws VariableNotFoundException{
        Type type = null;

        try {
            type =  this.variableTypesSupported.get(input);
        } catch (NullPointerException e) {
            throw new VariableNotFoundException();
        }
        return type;
    }

    public Object execute(String input) {
        Object toReturn = new Object();

        String varName = firstWord(input);
        input = removeFirstWord(input);

        String varTypeSTR = firstWord(input);
        input = removeFirstWord(input);

        String varValueSTR = firstWord(input);
        input = removeFirstWord(input);

        Type varType = null;

        try {
            varType = this.findType(varTypeSTR);
        } catch (VariableNotFoundException e) {
           toReturn =  "The Variable Type is not supported";
        }

        varType.setValue(varValueSTR);

        this.var.insertNameTypeValue(varName, varType, varType.getValue());

        toReturn = "Ok";

        return toReturn;
    }

}
