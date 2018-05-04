package org.interpreter.commands;

import org.interpreter.Interpreter;
import org.interpreter.operations.Operation;
import org.interpreter.variables.Type;
import org.interpreter.variables.VariableContainer;

import java.io.Serializable;
import java.util.Map;

public class CalcCommand extends Interpreter implements Command, Serializable {
    private VariableContainer var;
    private Map<String, Type> variableTypesSupported;
    private Map<String, Operation> operations;

    public CalcCommand(VariableContainer variableContainer,  Map<String, Operation> operations) {
        this.var = variableContainer;
        this.operations = operations;
    }


    //format of the key: [<type>] <operator> [<type>]
    private String generateOperationMapKey(String input) {
        input = removeFirstWord(input);

        String firstVarToAdd = firstWord(input);
        input = removeFirstWord(input);

        String operator = firstWord(input);
        input = removeFirstWord(input);

        String secondVarToAdd = firstWord(input);
        input = removeFirstWord(input);

        return var.getType(firstVarToAdd).toString() + " " + operator + " " + var.getType(secondVarToAdd).toString();
    }

    public Object execute(String input) {
        String operationMapKey =  generateOperationMapKey(input);

        Operation operation = operations.get(operationMapKey);

        operation.execute(input);

        return "Ok";
    }

}
