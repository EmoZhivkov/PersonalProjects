package org.interpreter.variables;

import java.io.Serializable;

public interface Type {
    void setValue(String input);
    Object getValue();
    String toString();
}
