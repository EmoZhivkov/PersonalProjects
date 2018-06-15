package org.textlines;

import org.textlines.Types.EmptyType;
import org.textlines.Types.TypeOfLine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class API {
    private static int counterLines = 0;
    ArrayList<TypeOfLine> typeOfLines;
    LineContainer lineContainer;
    String fileName;

    API(ArrayList<TypeOfLine> typeOfLines, LineContainer lineContainer, String fileName) {
        this.typeOfLines = typeOfLines;
        this.lineContainer = lineContainer;
        this.fileName = fileName;
    }

    public TypeOfLine getTypeOfText(String string) {
        TypeOfLine typeOfLine = new EmptyType();
        for (TypeOfLine type :
                this.typeOfLines) {
            if (type.isCurrentType(string)) {
                typeOfLine = type;
            }
        }
        return typeOfLine;
    }

    //TODO implement the main method that fills the LineContainer and then outputs the result
    public void fillTheLineContainerFromAFile(String fileName) {
        File file = new File(fileName);


        List<String> lines = new ArrayList<>();

    }
}
