package org.dequeue;

import org.junit.Assert;
import org.junit.Test;

public class DequeueTest {
    @Test
    public void testEnqueueFront() {
        Dequeue test = new Dequeue();
        test.enqueueFront("hello");
        test.enqueueFront("world");

        Assert.assertEquals("hello", test.dequeueFront());
    }

    @Test
    public void testEnqueueBack() {
        Dequeue test = new Dequeue();
        test.enqueueBack("hello");
        test.enqueueBack("world");

        Assert.assertEquals("hello", test.dequeueBack());
    }

    @Test
    public void testDequeueFront() {
        Dequeue test = new Dequeue();
        test.enqueueFront("hello");
        test.enqueueFront("world");

        Assert.assertEquals("hello", test.dequeueFront());
    }

    @Test
    public void testDequeueBack() {
        Dequeue test = new Dequeue();
        test.enqueueFront("hello");
        test.enqueueFront("world");

        Assert.assertEquals("world", test.dequeueBack());
    }
}
