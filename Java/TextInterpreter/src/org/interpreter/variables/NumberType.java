package org.interpreter.variables;

import java.io.Serializable;

public class NumberType implements Type, Serializable {
    private Object value;
    public static final long serialVersionUID = 43L;
    public void setValue(String input) {
        this.value = Integer.parseInt(input);
    }

    public Object getValue() {
        return this.value;
    }
    public String toString(){
        return "[" + "number" +"]";
    }
}
