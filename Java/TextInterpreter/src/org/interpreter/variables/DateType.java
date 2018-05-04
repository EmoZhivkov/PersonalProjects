package org.interpreter.variables;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateType implements Type, Serializable {
    private Date value;
    public static final long serialVersionUID = 42L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public void setValue(String input){
        Date date = new Date();
        try {
            date = formatter.parse(input);
        } catch (ParseException e) {
            System.out.println("Incorrect date input!");
        }
        this.value = date;
    }

    public Object getValue(){
        return this.value;
    }

    public void setValueByDate(Date date) {
        this.value = date;
    }

    public String toString(){
        return "[" + "date" +"]";
    }
}
