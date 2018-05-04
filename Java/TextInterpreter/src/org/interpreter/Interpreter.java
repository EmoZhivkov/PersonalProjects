package org.interpreter;

import org.interpreter.commands.Command;

import org.interpreter.variables.Type;
import org.interpreter.variables.VariableContainer;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
    private Map<String, Command> commands;
    private VariableContainer variables;
    private Map<String, Type> variableTypesSupported;

    //used only to initialise the helper methods firstWord and removeFirstWord
    public Interpreter() {

    }

    public Interpreter(HashMap<String, Command> commands, VariableContainer variables, HashMap<String, Type> variableTypesSupported) {
        this.commands = commands;
        this.variables = variables;
        this.variableTypesSupported = variableTypesSupported;
    }

    public Object executeCommand(String input)  {
        Object toReturn = new Object();
        try {
            Command current = this.getCommand(this.firstWord(input));
            input = this.removeFirstWord(input);
            toReturn = current.execute(input);
        }
        catch (NullPointerException e) {
            toReturn = "Err";
            e.printStackTrace();
        }
        return toReturn;
    }

    public Command getCommand(String string) {
        return this.commands.get(string);
    }

    public Map<String, Type> getVariableTypesSupported() {
        return this.variableTypesSupported;
    }

    public VariableContainer getVariables() {
        return this.variables;
    }

    public void setVariables(VariableContainer variableContainer) {
        this.variables = variableContainer;
    }

    protected String firstWord(String input) {
        String firstWord = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                break;
            }
            firstWord += input.charAt(i);
        }

        return firstWord;
    }

    public String removeFirstWord(String input) {
        String firstWord = firstWord(input);
        String withoutFirstWord = "";

        for (int i = firstWord.length() + 1; i < input.length(); i++) {
            withoutFirstWord += input.charAt(i);
        }

        return withoutFirstWord;
    }
}
