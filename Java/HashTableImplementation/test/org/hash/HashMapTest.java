package org.hash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    @Test
    public void testInsert() {
        HashMap test = new HashMap();
        Person person = new Person("Gosho", 234);

        int hash = person.hashCode();

        test.insert(person, 5);
        HashEntry[] h= test.getTable();
        Assert.assertEquals(5, h[hash].getGrade());
    }
    @Test
    public void testGet() {
        HashMap test = new HashMap();
        Person person = new Person("Gosho", 234);
        test.insert(person, 5);

        HashEntry t = test.get(person);
        Assert.assertEquals(5 , t.getGrade());
    }
    @Test
    public void testDelete() {
        HashMap test = new HashMap();
        Person person = new Person("Gosho", 234);

        test.insert(person, 5);
        test.delete(person);

        int hash = person.hashCode();
        HashEntry[] t = test.getTable();
        Assert.assertEquals(null, t[hash]);
    }
}
