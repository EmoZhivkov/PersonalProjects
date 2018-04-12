package org.hash;

public class Person {
    private String name;
    private int phoneNumber;

    Person(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        int h =  this.phoneNumber;
        for (int i = 0; i < 2; i++) {
            int digit = h % 10;
            h = h/10;
            hash = (int) (hash + digit*Math.pow(10, i));
        }
        return hash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
