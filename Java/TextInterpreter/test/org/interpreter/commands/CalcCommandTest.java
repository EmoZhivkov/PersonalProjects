package org.interpreter.commands;

import org.interpreter.Interpreter;
import org.interpreter.operations.*;
import org.interpreter.variables.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CalcCommandTest {
    VariableContainer variable = new VariableContainer();
    HashMap<String, Type> variableTypesSupported = new HashMap<>();
    HashMap<String, Operation> operations = new HashMap<>();
    HashMap<String, Command> command = new HashMap<>();
    Interpreter interpreter;
    SimpleDateFormat formatter;

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

        formatter = new SimpleDateFormat("dd/MM/yyyy");

        interpreter = new Interpreter(command, variable, variableTypesSupported);
    }

    @Test
    public void testDateNumberAddition() {
        interpreter.executeCommand("set date date 12/03/2000");
        interpreter.executeCommand("set number number 3");

        interpreter.executeCommand("calc date date + number");

        Date date1 = new Date();
        try {
            date1 = formatter.parse("15/03/2000");
        } catch (ParseException e) {
            System.out.println("Incorrect date input!");
        }

        Assert.assertEquals(date1,variable.getValue("date"));
    }

    @Test
    public void testDateNumberSubstraction() {
        interpreter.executeCommand("set date date 12/03/2000");
        interpreter.executeCommand("set number number 3");

        interpreter.executeCommand("calc date date - number");

        Date date1 = new Date();
        try {
            date1 = formatter.parse("09/03/2000");
        } catch (ParseException e) {
            System.out.println("Incorrect date input!");
        }

        Assert.assertEquals(date1,variable.getValue("date"));
    }

    @Test
    public void testNumberNumberAddition() {
        interpreter.executeCommand("set number number 5");
        interpreter.executeCommand("set number1 number 3");

        interpreter.executeCommand("calc number number + number1");
        Assert.assertEquals(8, variable.getValue("number"));
    }

    @Test
    public void testNumberNumberMultiplication() {
        interpreter.executeCommand("set number number 5");
        interpreter.executeCommand("set number1 number 3");

        interpreter.executeCommand("calc number number * number1");
        Assert.assertEquals(15, variable.getValue("number"));
    }

    @Test
    public void testNumberNumberSubstraction() {
        interpreter.executeCommand("set number number 5");
        interpreter.executeCommand("set number1 number 3");

        interpreter.executeCommand("calc number number - number1");
        Assert.assertEquals(2, variable.getValue("number"));
    }

    @Test
    public void testStringNumberAddition() {
        interpreter.executeCommand("set number number 5");
        interpreter.executeCommand("set string string oopa");

        interpreter.executeCommand("calc string string + number");
        Assert.assertEquals("oopa5", variable.getValue("string"));
    }

    @Test
    public void testStringNumberMultiplication() {
        interpreter.executeCommand("set number number 3");
        interpreter.executeCommand("set string string oopa");

        interpreter.executeCommand("calc string string * number");
        Assert.assertEquals("oopaoopaoopa", variable.getValue("string"));
    }

    @Test
    public void testStringStringAddition() {
        interpreter.executeCommand("set string1 string apoo");
        interpreter.executeCommand("set string string oopa");

        interpreter.executeCommand("calc string string + string1");
        Assert.assertEquals("oopaapoo", variable.getValue("string"));
    }
}
