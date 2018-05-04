package org.interpreter.variables;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class VariableContainer implements Serializable {
    private Map<String, Object> NameValuePair;
    private Map<String, Type> NameTypePair;

    public VariableContainer() {
        this.NameValuePair = new HashMap<>();
        this.NameTypePair = new HashMap<>();
    }

    private void putNameValue(String name, Object value) {
        this.NameValuePair.put(name, value);
    }

    private void putNameType(String name, Type type) {
        this.NameTypePair.put(name, type);
    }

    public void insertNameTypeValue(String name, Type type, Object value) {
        this.putNameType(name, type);
        this.putNameValue(name, value);
    }

    public void removeEntry(String input) {
        this.NameTypePair.remove(input);
        this.NameValuePair.remove(input);
    }

    @Override
    public String toString() {
        return NameValuePair.toString();
    }

    public void copy(VariableContainer variableContainer) {
        this.NameValuePair = variableContainer.getNameValuePair();
        this.NameTypePair = variableContainer.getNameTypePair();
    }

    public Map<String, Object> getNameValuePair() {
        return this.NameValuePair;
    }

    public Map<String, Type> getNameTypePair() {
        return this.NameTypePair;
    }

    public Object getValue(String  name) {
        return this.NameValuePair.get(name);
    }

    public Type getType(String name) {
        return this.NameTypePair.get(name);
    }
}
