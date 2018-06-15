package org.textlines.Types;

public class TextType implements TypeOfLine{

    @Override
    public boolean isCurrentType(String string) {
        boolean b = false;
        if (Character.isLetter(string.charAt(0))) {
            b = true;
        }
        return b;
    }

    @Override
    public String toString() {
        return "TextType";
    }
}
