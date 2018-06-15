package org.textlines.Types;

public class NumberType implements TypeOfLine{
    @Override
    public boolean isCurrentType(String string) {
        boolean b = true;
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                b = false;
                break;
            }
        }
        return b;
    }
    @Override
    public String toString() {
        return "NumberType";
    }
}

