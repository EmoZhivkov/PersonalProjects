package org.interpreter.operations;

import org.interpreter.Interpreter;
import org.interpreter.variables.DateType;
import org.interpreter.variables.Type;
import org.interpreter.variables.VariableContainer;

import java.util.Calendar;
import java.util.Date;

public class DateNumberAddition extends Interpreter implements Operation {
    VariableContainer variableContainer;

    public DateNumberAddition(VariableContainer variableContainer) {
        this.variableContainer = variableContainer;
    }

    public void execute(String input) {
        String varToOverride = firstWord(input);
        input = removeFirstWord(input);

        String firstVarToAdd = firstWord(input);
        input = removeFirstWord(input);

        input = removeFirstWord(input);//remove the operator

        String secondVarToAdd = firstWord(input);
        input = removeFirstWord(input);

        DateType currentType = (DateType) this.variableContainer.getType(firstVarToAdd);
        Date current = (Date) currentType.getValue();

        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.DATE, (int) this.variableContainer.getValue(secondVarToAdd));
        current = c.getTime();

        currentType.setValueByDate(current);

        this.variableContainer.removeEntry(varToOverride);
        this.variableContainer.insertNameTypeValue(varToOverride, currentType, currentType.getValue());
    }
}
