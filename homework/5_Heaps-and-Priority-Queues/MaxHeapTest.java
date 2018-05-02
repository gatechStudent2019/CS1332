import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.*;

import static org.junit.Assert.*;

public class MaxHeapTest {
    private MaxHeap<Integer> myHeap;
    private MaxPriorityQueue<Integer> myQueue;

    @Before
    public void setUp() throws Exception {
        myHeap = new MaxHeap<>();
        myQueue = new MaxPriorityQueue<>();
    }

    @org.junit.Test
    public void basicHeapTest() {
        assertTrue(myHeap.isEmpty());
        assertEquals(0, myHeap.size());
        myHeap.add(10);
        assertEquals(1, myHeap.size());
        assertEquals(10, myHeap.getBackingArray()[1]);
        myHeap.add(7);
        assertEquals(2, myHeap.size());
        assertEquals(7, myHeap.getBackingArray()[2]);
        myHeap.add(15);
        assertEquals(3, myHeap.size());
        assertEquals(15, myHeap.getBackingArray()[1]);
        assertEquals(7, myHeap.getBackingArray()[2]);
        assertEquals(10, myHeap.getBackingArray()[3]);
        myHeap.add(9);
        assertEquals(9, myHeap.getBackingArray()[2]);
        assertEquals(7, myHeap.getBackingArray()[4]);
        assertEquals(15, myHeap.getBackingArray()[1]);
        assertEquals(10, myHeap.getBackingArray()[3]);
        assertEquals(Integer.valueOf(15), myHeap.remove());
        assertEquals(3, myHeap.size());
        assertEquals(10, myHeap.getBackingArray()[1]);
        assertEquals(7, myHeap.getBackingArray()[3]);
        assertEquals(9, myHeap.getBackingArray()[2]);
        assertEquals(Integer.valueOf(10), myHeap.remove());
        assertEquals(2, myHeap.size());
        assertEquals(9, myHeap.getBackingArray()[1]);
        assertEquals(7, myHeap.getBackingArray()[2]);
        assertEquals(Integer.valueOf(9), myHeap.remove());
        assertEquals(1, myHeap.size());
        assertEquals(7, myHeap.getBackingArray()[1]);
        assertEquals(Integer.valueOf(7), myHeap.remove());
        assertEquals(0, myHeap.size());
        assertTrue(myHeap.isEmpty());
        for (int i = 0; i < 5; i++) {
            assertNull(myHeap.getBackingArray()[i]);
        }
        Integer[] testArray = {10, 15, 7, 9, 25, 13, 4};
        myHeap = new MaxHeap<Integer>(Arrays.stream(testArray).collect(Collectors.toCollection(ArrayList::new)));
        Integer[] correctArray = {25, 15, 13, 9, 10, 7, 4};
        assertEquals(7, myHeap.size());
        assertEquals(15, myHeap.getBackingArray().length);
        for (int i = 0; i < correctArray.length; i++) {
            assertEquals(correctArray[i], myHeap.getBackingArray()[i + 1]);
        }
    }

    @org.junit.Test
    public void basicQueueTest() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue(10);
        myQueue.enqueue(15);
        myQueue.enqueue(7);
        myQueue.enqueue(4);
        myQueue.enqueue(20);
        myQueue.enqueue(14);
        myQueue.enqueue(18);
        myHeap.add(10);
        myHeap.add(15);
        myHeap.add(7);
        myHeap.add(4);
        myHeap.add(20);
        myHeap.add(14);
        myHeap.add(18);
        assertEquals(7, myQueue.size());
        assertArrayEquals(myHeap.getBackingArray(), myQueue.getBackingHeap().getBackingArray());
        for (int i = 0; i < 7; i++) {
            assertEquals(myHeap.remove(), myQueue.dequeue());
        }
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void exceptionTest() {
        try {
            myHeap = new MaxHeap<>(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            myHeap.add(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            myHeap.remove();
            fail();
        } catch (NoSuchElementException e) {
        }
        try {
            myQueue.enqueue(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            myQueue.dequeue();
            fail();
        } catch (NoSuchElementException e) {
        }
    }

    @org.junit.Test
    public void edgeCaseTests() {
        myHeap.add(20);
        myHeap.add(15);
        myHeap.add(8);
        myHeap.add(30);
        assertEquals(30, myHeap.getBackingArray()[1]);
        assertEquals(20, myHeap.getBackingArray()[2]);
        assertEquals(8, myHeap.getBackingArray()[3]);
        assertEquals(15, myHeap.getBackingArray()[4]);
        Integer[] myArray = {5, 16, 7, 48, 32, 10, 9, 18, 24, 3, 60};
        myHeap = new MaxHeap<Integer>(Arrays.stream(myArray).collect(Collectors.toCollection(ArrayList::new)));
        assertEquals(60, myHeap.getBackingArray()[1]);
        assertEquals(48, myHeap.getBackingArray()[2]);
        assertEquals(10, myHeap.getBackingArray()[3]);
        assertEquals(24, myHeap.getBackingArray()[4]);
        assertEquals(32, myHeap.getBackingArray()[5]);
        assertEquals(7, myHeap.getBackingArray()[6]);
        assertEquals(9, myHeap.getBackingArray()[7]);
        assertEquals(18, myHeap.getBackingArray()[8]);
        assertEquals(5, myHeap.getBackingArray()[9]);
        assertEquals(3, myHeap.getBackingArray()[10]);
        assertEquals(16, myHeap.getBackingArray()[11]);
        myHeap.clear();
        assertEquals(0, myHeap.size());
        myQueue.enqueue(10);
        assertEquals(Integer.valueOf(10), myQueue.dequeue());
        myQueue.enqueue(5);
        assertEquals(Integer.valueOf(5), myQueue.dequeue());
        myQueue.enqueue(8);
        assertEquals(Integer.valueOf(8), myQueue.dequeue());
        assertTrue(myQueue.isEmpty());
        for (int i = 0; i < 101; i++) {
            myQueue.enqueue(i);
        }
        for (int i = 200; i > 100; i--) {
            myQueue.enqueue(i);
        }
        for (int i = 200; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), myQueue.dequeue());
        }
    }
}