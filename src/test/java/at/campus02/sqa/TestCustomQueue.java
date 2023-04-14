package at.campus02.sqa;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCustomQueue {
    @Test
    public void testPopFromEmptyQueue() {
        CustomQueue customQueue = new CustomQueue();
        String result = customQueue.pop();
        assertNull(result);
    }

    @Test
    public void testPushBadStrings() {
        CustomQueue customQueue = new CustomQueue();
        boolean result = customQueue.push("");
        assertFalse(result);
        result = customQueue.push("bad! string");
        assertFalse(result);
    }

    @Test
    public void testQueueOrder() {
        CustomQueue customQueue = new CustomQueue();
        customQueue.push("one");
        customQueue.push("two");
        customQueue.push("three");
        assertEquals("one", customQueue.pop());
        assertEquals("two", customQueue.pop());
        assertEquals("three", customQueue.pop());
        // assertNull(customQueue.pop());
    }
}
