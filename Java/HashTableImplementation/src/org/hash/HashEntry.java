package org.hash;

public class HashEntry {
    private Person key;
    private int grade;
    private int hashCode;

    public HashEntry(Person current, int grade) {
        this.hashCode = current.hashCode();
        this.key = current;
        this.grade = grade;
    }

    public String getKey() {
        return key.getName();
    }
    public int getGrade() {
        return grade;
    }
}
