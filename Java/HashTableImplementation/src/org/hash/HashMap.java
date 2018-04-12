package org.hash;

public class HashMap {
    HashEntry[] table = new HashEntry[100];

    public HashEntry[] getTable() {
        return table;
    }

    public void insert(Person person, int grade) {
        HashEntry entry = new HashEntry(person, grade);
        int hash = person.hashCode();
        table[hash] = entry;
    }

    public HashEntry get(Person person) {
        int hash = person.hashCode();
        if (table[hash] != null) {
            return table[hash];
        }
        return null;
    }

    public void delete(Person person) {
        int hash = person.hashCode();
        if (table[hash] == null){
            System.out.println("There is no such element!");
        }
        table[hash] = null;
    }
}

