package org.interpreter.variables;

import java.io.Serializable;

public class StringType implements Type, Serializable {
    private String value;
    public static final long serialVersionUID = 44L;
    public void setValue(String input){
        this.value = input;
    }

    public Object getValue(){
        return this.value;
    }

    public String toString(){
        return "[" + "string" +"]";
    }
}
