package org.interpreter.commands;

import java.io.Serializable;

public interface Command extends Serializable {
    Object execute(String input);
}
