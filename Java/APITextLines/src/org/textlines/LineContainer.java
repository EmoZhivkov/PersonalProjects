package org.textlines;

import org.textlines.Types.TypeOfLine;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

public class LineContainer{
    Map<Integer, String> lineNumberContent;
    Map<Integer, TypeOfLine> lineNumberType;

    LineContainer(Map<Integer, String> lineNumberContent, Map<Integer, TypeOfLine> lineNumberType) {
        this.lineNumberContent = lineNumberContent;
        this.lineNumberType = lineNumberType;
    }

    public void addLineNumberContentType(int lineNumber, String content, TypeOfLine type) {
        this.lineNumberContent.put(lineNumber, content);
        this.lineNumberType.put(lineNumber, type);
    }

    public String getLineIndexContentTypeAtIndex(int lineIndex) {
        String string = new String();
        string = string + lineIndex + " " + getContent(lineIndex) + " " + getType(lineIndex).toString();
        return string;
    }

    public String getContent(int lineIndex) {
        return this.lineNumberContent.get(lineIndex);
    }

    public TypeOfLine getType(int lineIndex) {
        return this.lineNumberType.get(lineIndex);
    }
}

