/**
 * Your implementation of a max priority queue.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class MaxPriorityQueue<T extends Comparable<? super T>>
    implements PriorityQueueInterface<T> {

    private HeapInterface<T> backingHeap;
    // Do not add any more instance variables. Do not change the declaration
    // of the instance variables above.

    /**
     * Creates a priority queue.
     */
    public MaxPriorityQueue() {
        backingHeap = new MaxHeap<T>();
    }

    /**
     * Adds an item to the priority queue.
     *
     * @param item the item to be added
     * @throws IllegalArgumentException if the item is null
     */
    @Override
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("error, item to enqueue is null"
                );
        }
        backingHeap.add(item);
    }

    /**
     * Removes and returns the first item in the priority queue.
     *
     * @throws java.util.NoSuchElementException if the priority queue is empty
     * @return the item dequeued
     */
    @Override
    public T dequeue() {
        if (backingHeap.size() == 0) {
            throw new java.util.NoSuchElementException("error, MaxPriorityQueue"
                + " is empty");
        }
        return backingHeap.remove();
    }

    /**
     * Returns if the priority queue is empty.
     *
     * @return a boolean representing if the priority queue is empty
     */
    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return backingHeap.isEmpty();
    }

    /**
     * Returns the size of the priority queue.
     *
     * @return the size of the priority queue
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return backingHeap.size();
    }

    /**
     * Clears the priority queue.
     */
    @Override
    public void clear() {
        backingHeap = new MaxHeap<T>();
    }

    /**
     * Returns the backing Heap
     *
     * @return the backing Heap
     */
    @Override
    public HeapInterface<T> getBackingHeap() {
        // DO NOT MODIFY THIS METHOD!
        return backingHeap;
    }
}