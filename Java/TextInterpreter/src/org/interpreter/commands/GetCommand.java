package org.interpreter.commands;

import org.interpreter.Interpreter;
import org.interpreter.variables.Type;
import org.interpreter.variables.VariableContainer;

import java.io.Serializable;
import java.util.Map;

//still doesn't handle the exception when there is no such variable name in the variable container
public class GetCommand extends Interpreter implements Command, Serializable {
    private VariableContainer var;
    private Map<String, Type> variableTypesSupported;

    public GetCommand(VariableContainer var, Map<String, Type> variableTypesSupported) {
        this.var = var;
        this.variableTypesSupported = variableTypesSupported;
    }

    @Override
    public Object execute(String input) {
        Type type = this.var.getType(input);
        Object value = this.var.getValue(input);
        return type.toString() + " " + value;
    }
}
