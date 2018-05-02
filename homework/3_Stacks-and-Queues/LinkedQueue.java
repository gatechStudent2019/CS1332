/**
 * Your implementation of a linked queue. It should NOT be circular.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

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
        } else if (size == 1) {
            result = head.getData();
            head = null;
            size--;
        } else {
            result = head.getData();
            LinkedNode<T> next = head.getNext();
            head.setNext(null);
            head = next;
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
        } else if (size == 0) {
            head = new LinkedNode<>(data);
            tail = head;
            size++;
        } else {
            LinkedNode<T> newNode = new LinkedNode<>(data);
            tail.setNext(newNode);
            tail = newNode;
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
        }
        return head.getData();
    }

    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the head of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the tail node
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }
}