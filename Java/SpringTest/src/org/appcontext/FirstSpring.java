package org.appcontext;

import org.springframework.context.ApplicationContext;

public class FirstSpring {
    String message;
    int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMessage(String message)  {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
