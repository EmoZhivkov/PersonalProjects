package org.textlines.Types;

public class EmptyType implements TypeOfLine{
    @Override
    public boolean isCurrentType(String string) {
        boolean b = false;
        if (string.equals("")) {
            b = true;
        }
        return b;
    }
    @Override
    public String toString() {
        return "EmptyType";
    }
}
