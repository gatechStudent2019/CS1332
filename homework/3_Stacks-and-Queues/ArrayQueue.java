/**
 * Your implementation of an array-backed queue.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Dequeue from the front of the queue.
     *
     * @return the data from the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() {
        T result = null;
        if (size == 0) {
            throw new java.util.NoSuchElementException("error: cannot dequeue "
                + "from an empty queue");
        } else {
            result = backingArray[front];
            backingArray[front] = null;
            if (size == 1) {
                front = 0;
            } else if (front == backingArray.length - 1) {
                front = 0;
            } else {
                front++;
            }
            size--;
        }
        return result;

    }

    /**
     * Add the given data to the queue.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error: cannot enqueue null "
                + "data");
        } else if (size == backingArray.length) {
            T[] tempArray = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                tempArray[i] = backingArray[front];
                if (front == size - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
            tempArray[size] = data;
            backingArray = tempArray;
            size++;
        } else {
            if (front + size >= backingArray.length) {
                backingArray[front + size - backingArray.length] = data;
            } else {
                backingArray[front + size] = data;
            }
            size++;
        }
    }

    /**
     * Retrieves the next data to be dequeued without removing it.
     *
     * @return the next data or null if the queue is empty
     */
    @Override
    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return backingArray[front];
        }
    }

    /**
     * Return true if this queue contains no elements, false otherwise.
     *
     * @return true if the queue is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    /**
     * Return the size of the queue.
     *
     * @return number of items in the queue
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the backing array of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }
}