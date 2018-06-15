package org.assemblyline.model;

import org.assemblyline.exceptions.ModelNotSupportedException;

public interface Model {
    void setModel(String input) throws ModelNotSupportedException;
    @Override
    String toString();
}
