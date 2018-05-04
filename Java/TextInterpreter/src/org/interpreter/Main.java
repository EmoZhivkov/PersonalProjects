package org.interpreter;

import org.interpreter.commands.*;
import org.interpreter.operations.*;
import org.interpreter.variables.*;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VariableContainer variable = new VariableContainer();

        HashMap<String, Type> variableTypesSupported = new HashMap<>();
        variableTypesSupported.put("string", new StringType());
        variableTypesSupported.put("number", new NumberType());
        variableTypesSupported.put("date", new DateType());

        HashMap<String, Operation> operations = new HashMap<>();
        operations.put("[string] + [string]", new StringStringAddition(variable));
        operations.put("[string] + [number]", new StringNumberAddition(variable));
        operations.put("[string] * [number]", new StringNumberMultiplication(variable));
        operations.put("[number] + [number]", new NumberNumberAddition(variable));
        operations.put("[number] - [number]", new NumberNumberSubstraction(variable));
        operations.put("[number] * [number]", new NumberNumberMultiplication(variable));
        operations.put("[date] + [number]", new DateNumberAddition(variable));
        operations.put("[date] - [number]", new DateNumberSubstraction(variable));

        HashMap<String, Command> command = new HashMap<>();
        command.put("reverse", new ReverseCommand());
        command.put("count-words", new WordCountCommand());
        command.put("reverse-words", new ReverseWordsCommand());
        command.put("set", new SetCommand(variable, variableTypesSupported));
        command.put("get", new GetCommand(variable, variableTypesSupported));
        command.put("calc", new CalcCommand(variable, operations));
        command.put("save", new SaveCommand(variable));
        command.put("load", new LoadCommand(variable));

        Interpreter interpreter = new Interpreter(command, variable, variableTypesSupported);

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            System.out.println(interpreter.executeCommand(input));
        }

    }
}
