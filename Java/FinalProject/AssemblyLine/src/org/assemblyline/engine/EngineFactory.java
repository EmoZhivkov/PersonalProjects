package org.assemblyline.engine;

import org.assemblyline.engine.Engine;
import org.assemblyline.exceptions.EngineNotSupportedException;

public interface EngineFactory {
    Engine createEngine(String input)throws EngineNotSupportedException;
}
