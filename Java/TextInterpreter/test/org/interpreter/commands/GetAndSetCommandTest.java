package org.interpreter.commands;

import org.interpreter.Interpreter;
import org.interpreter.operations.*;
import org.interpreter.variables.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class GetAndSetCommandTest {
    VariableContainer variable = new VariableContainer();
    HashMap<String, Type> variableTypesSupported = new HashMap<>();
    HashMap<String, Operation> operations = new HashMap<>();
    HashMap<String, Command> command = new HashMap<>();
    Interpreter interpreter;

    @Before
    public void setMaps() {



        variableTypesSupported.put("string", new StringType());
        variableTypesSupported.put("number", new NumberType());
        variableTypesSupported.put("date", new DateType());


        operations.put("[string] + [string]", new StringStringAddition(variable));
        operations.put("[string] + [number]", new StringNumberAddition(variable));
        operations.put("[string] * [number]", new StringNumberMultiplication(variable));
        operations.put("[number] + [number]", new NumberNumberAddition(variable));
        operations.put("[number] - [number]", new NumberNumberSubstraction(variable));
        operations.put("[number] * [number]", new NumberNumberMultiplication(variable));
        operations.put("[date] + [number]", new DateNumberAddition(variable));
        operations.put("[date] - [number]", new DateNumberSubstraction(variable));


        command.put("reverse", new ReverseCommand());
        command.put("count-words", new WordCountCommand());
        command.put("reverse-words", new ReverseWordsCommand());
        command.put("set", new SetCommand(variable, variableTypesSupported));
        command.put("get", new GetCommand(variable, variableTypesSupported));
        command.put("calc", new CalcCommand(variable, operations));

        interpreter = new Interpreter(command, variable, variableTypesSupported);
    }

    @Test
    public void testSetCommand() {
        String input = "name string ooopa";

        Command current = interpreter.getCommand("set");
        current.execute(input);

        Assert.assertEquals("ooopa", variable.getValue("name"));
    }

    //insertNameTypeValue(String name, Type type, Object value)

    @Test
    public void testGetCommand() {
        Command current = interpreter.getCommand("get");

        String name = "name";
        Type type = new StringType();
        variable.insertNameTypeValue(name, type, "ooopa");

        Assert.assertEquals("[string] ooopa", current.execute("name"));
    }
}
