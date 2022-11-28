package se.hig.aod.lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * xxxxxx
 *
 * @author xxxx
 */
class HeapPriorityQueueTest {

    static final Integer[] INT_FIXTURE = {3,4,5}; // TODO fill with random integers

    HeapPriorityQueue<Integer> nonEmptyQueue;
    HeapPriorityQueue<Integer> emptyQueue;


    @BeforeEach
    void setUp() throws Exception {
        nonEmptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);
        emptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);

        for (int testData : INT_FIXTURE) {
            nonEmptyQueue.enqueue(testData);
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        nonEmptyQueue = null;
        emptyQueue = null;
    }

    @Test
    void testClearNonEmptyQueue() {
        nonEmptyQueue.clear();
        assertTrue(nonEmptyQueue.isEmpty(), "intQueue borde vara tom efter en clear");
    }

    @Test
    void testClearEmptyQueue() {
        emptyQueue.clear();
        assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty after clear");
    }

    @Test
    void testNonEmptySize(){
        nonEmptyQueue.size();
        assertEquals(3, nonEmptyQueue.size(), "Storleken borde vara 3");

    }
    @Test
    void testEmptySize(){
        emptyQueue.size();
        assertEquals(0, emptyQueue.size(),"Borde vara tom" );

    }

    @Test
    void testEnqeueEmptyQueue(){
        emptyQueue.enqueue(1);
        assertEquals(1, emptyQueue.size(), "Storleken borde vara 1");

    }

    @Test
    void testEnqueueNonEmptyQueue(){
        assertThrows(PriorityQueueFullException.class, ()-> nonEmptyQueue.enqueue(6));
    }

    @Test
    void testDequeueNonEmptyQueue(){
        nonEmptyQueue.dequeue();
        assertEquals(2,nonEmptyQueue.size());
    }

    @Test
    void testDequeueEmptyQueue() {
        assertThrows(PriorityQueueEmptyException.class, ()-> emptyQueue.dequeue(), "Borde kasta empty queue execption");
    }

    @Test
    void testGetFrontEmptyQueue() {
        assertThrows(PriorityQueueEmptyException.class,()-> emptyQueue.getFront());
    }

    @Test
    void testGetFrontNonEmptyQueue() {
        assertEquals(nonEmptyQueue.getFront(), 5);
    }




}
